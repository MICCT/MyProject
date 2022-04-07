<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../home/header.jsp" />
<body>
	<div align="center">
	<div><h1>${message }</h1></div>
	<input type="button" onclick="location.href='memberLoginForm.do'" value="로그인">
	</div>
</body>
</html>