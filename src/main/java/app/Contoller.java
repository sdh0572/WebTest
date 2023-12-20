package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phonebook.OraclePhonebookDAO;
import phonebook.Phonebook;

@WebServlet("/")
public class Contoller extends HttpServlet {
	OraclePhonebookDAO dao;
	
	public Contoller() {
		dao = new OraclePhonebookDAO();//멤버 객체 선언시 유의
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getRequestURI());
		System.out.println(request.getQueryString());
		System.out.println(request.getParameter("idx"));
		
		String command = request.getRequestURI().substring(1);
		String page = "index.jsp";
		Phonebook pb=null;
		int id=0;
		switch (command) {
		case "insertform": 
			page = "insertform.jsp"; 
			break;
		case "insert" :
			pb=new Phonebook();
			pb.setHp(request.getParameter("hp"));
			pb.setName(request.getParameter("name"));
			pb.setMemo(request.getParameter("memo"));
			//System.out.println(pb);
			dao.insert(pb);
			page="index.jsp"; 
			break; 
		case "list"  : 
			request.setAttribute("list", dao.selectAll());
			page = "list.jsp"; 
			break;
		case "view" :
			id=Integer.parseInt(request.getParameter("id"));
			request.setAttribute("pb", dao.selectById(id));
			page="view.jsp"; 
			break; 
		case "searchlist" : 
			String key = request.getParameter("key");
			request.setAttribute("list", dao.search(key));
			page="searchlist.jsp"; 
			break; 
		case "updateform" :
			id=Integer.parseInt(request.getParameter("id"));
			request.setAttribute("pb", dao.selectById(id));
			page="updateform.jsp"; 
			break; 
		case "update": 
			pb=new Phonebook();
			pb.setId(Integer.parseInt(request.getParameter("id")));
			pb.setHp(request.getParameter("hp"));
			pb.setName(request.getParameter("name"));
			pb.setMemo(request.getParameter("memo"));
			//System.out.println(pb);
			dao.update(pb);
			page = "index.jsp";	
			break;
		case "delete" :
			id = Integer.parseInt(request.getParameter("id"));
			dao.delete(id);
			page = "index.jsp";
			break;
		default : break;
		}
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/"+page);
		disp.forward(request, response);
	}

}
