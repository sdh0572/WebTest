<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr>
	<th>아이디</th>
	<th>이름</th>
	<th>전화번호</th>
	<th>메모</th>
</tr>
<c:forEach var="pb" items="${list}">

<tr>
	<td><a href="javascript:updatefn('view?id=${pb.id}')">${pb.id}</a></td>
	<td>${pb.name}</td>
	<td>${pb.hp}</td>
	<td>${pb.memo}</td>
</tr>
</c:forEach>
</table>

</body>
</html>