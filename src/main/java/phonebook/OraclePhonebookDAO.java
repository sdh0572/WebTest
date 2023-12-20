package phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OraclePhonebookDAO implements PhonebookInter{
	Connection conn;
	public OraclePhonebookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isConnection() {
		if(conn==null) {
			return false;
		}
		return true;
	}
	
	
	@Override
	public int insert(Phonebook pb) {
		try {
		String sql="insert into phonebook values(phonebook_id_seq.nextval,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pb.getName());
		ps.setString(2, pb.getHp());
		ps.setString(3, pb.getMemo());
		int result = ps.executeUpdate();
		ps.close();
		return result;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Phonebook> selectAll() {
		try {
		String sql="select * from phonebook";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<Phonebook> list = new ArrayList<Phonebook>();
		while(rs.next()) {
			Phonebook pb = new Phonebook(rs.getInt("id"), rs.getString("name"), rs.getString("hp"), rs.getString("memo"));
			list.add(pb);
		}
		rs.close();ps.close();
		return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Phonebook selectById(int id) {
		try {
			String sql="select * from phonebook where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Phonebook pb = new Phonebook(rs.getInt("id"), rs.getString("name"), rs.getString("hp"), rs.getString("memo"));
				rs.close();ps.close();
				return pb;
			}
			}catch (Exception e) {
				e.printStackTrace();
			}return null;
	}

	@Override
	public int update(Phonebook pb) {
		try {
			String sql="update phonebook set name=?, hp=?, memo=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getHp());
			ps.setString(3, pb.getMemo());
			ps.setInt(4, pb.getId());
			int result = ps.executeUpdate();
			ps.close();
			return result;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
	}

	@Override
	public int delete(int id) {
		try {
			String sql="delete from phonebook where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			ps.close();
			return result;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
	}

	@Override
	public List<Phonebook> search(String s) {
		try {
		s="%"+s+"%";
		String sql="select * from phonebook where name like ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, s);
		ResultSet rs=ps.executeQuery();
		List<Phonebook> list = new ArrayList<Phonebook>();
		while(rs.next()) {
			Phonebook pb = new Phonebook(rs.getInt("id"), rs.getString("name"), rs.getString("hp"), rs.getString("memo"));
			list.add(pb);
		}
		rs.close();ps.close();
		return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
