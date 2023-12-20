<%@page import="phonebook.Phonebook"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="phonebook.OraclePhonebookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
//reqpage 첫번째 입력값을 url, 두번째 입력값을 div 위치 지정
function reqpage(page) {
	fetch('/'+page)
	.then(obj => obj.text())
	.then(text => document.querySelector("div").innerHTML = text
	);
}
function search(obj) {
	var key=obj.value;
	fetch ('/searchlist?key='+key)
	.then(o => o.text())
	.then(data => document.querySelector("#list").innerHTML = data
	);
}
function updatefn(page) {
	fetch('/'+page)
	.then(obj => obj.text())
	.then(text => document.querySelector("#view").innerHTML = text
	);
}
</script>
</head>

<body>
<jsp:include page="/WEB-INF/insertform.jsp"/>
<fieldset>
<legend>목록리스트</legend>
검색:<input type="text" name="search" id="search" onkeyup="search(this)"><br>
<div id="list" style="height: 300px; overflow: scroll; overflow-x:hidden ">
<script>reqpage('list');</script>
</div>
</fieldset>
<fieldset>
<legend>상세보기</legend>
<div id="view"></div>
</fieldset>
</body>
</html>