<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/insert" method="post">
<fieldset>
<legend>전화번호 입력폼</legend>
	이름:<input type="text" name="name" id="name"><br>
	전화번호:<input type="text" name="hp" id="hp"><br>
	메모:<input type="text" name="memo" id="memo"><br>
	<input type="submit" value="입력">
</fieldset>
</form>
</body>
</html>