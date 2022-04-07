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
		<div>
			<h1>로 그 인</h1>
		</div>
	</div>
	<div align="center">
		<form id="frm" action="memberLogin.do" method="post">
			<div >
				<table border="1">
					<tr>
						<th width="100">아이디</th>
						<td width="100"><input type="text" id="id" name="id"></td>
					</tr>

					<tr>
						<th width="100">패스워드</th>
						<td width="100"><input type="text" id="password"name="password"></td>
					</tr>


				</table>
			</div><br>
			 <input type="submit" value="로그인">
			 <input type="button" value="회원가입" onclick="memberJoin.do">
			 <input type="reset" value="취소">
		</form>
	</div>
</body>
</html>