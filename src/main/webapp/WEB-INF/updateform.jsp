<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<fieldset>
<legend>전화번호 수정폼</legend>
	아이디:<input type="text" name="id" id="id" value="${pb.id}" readonly><br>
	이름:<input type="text" name="name" id="name" value="${pb.name}"><br>
	전화번호:<input type="text" name="hp" id="hp" value="${pb.hp}"><br>
	메모:<input type="text" name="memo" id="memo" value="${pb.memo}"><br>
	<input type="submit" value="전화번호부수정">
</fieldset>
</form>
</body>
</html>