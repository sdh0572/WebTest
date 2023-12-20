<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디:${pb.id}<br>
이름:${pb.name}<br>
전화번호:${pb.hp}<br>
메모:${pb.memo}<br>
<input type="button" value="수정" onclick="javascript:updatefn('updateform?id=${pb.id}')">
<input type="button" value="삭제" onclick="location.href='delete?id=${pb.id}'">
</body>
</html>