<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

function Comparison() {
	//password 에 들어있는 value(입력값) 값을 찾아서 담는다..
	var pw = frm.password.value;
	var pwr = frm.passwordRE.value;
	
	if(frm.id.value ==""){
		alert("ID 값이 비었습니다.")
		frm.id.focus();
		return false;
	}
	if(frm.name.value ==""){
		alert("이름을 입력해주세요]")
		frm.name.focus();
		return false;
	}
	
	if(pw == pwr){
		frm.submit(); //id값 frm을 찾아서 내용을 제출한다
	}else {
		//패스워드가 일치하지 않으면 내가썻던 글자들을 지워준다. (reset 역할)
		alert("패스워드가 틀렸습니다.");
		frm.password.value=""; 
		frm.passwordRE.value="";
		frm.password.focus(); //패스워드 입력칸으로 이동
		return false;
	}
}

</script>
</head>
<jsp:include page="../home/header.jsp" />
<body>
	<div align="center">
		<div><h1>회원가입</h1></div>
		<div>
			<form id="frm" action="memberJoin.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="150">아이디</th>
							<td width="200">   <!-- readonly="required" : 필수입력 -->
							<input type="text" id="id" name="id" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">패스워드</th>
							<td width="200">   
							<input type="password" id="password" name="password" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">패스워드 재입력</th>
							<td width="200">   
							<input type="password" id="passwordRE" name="passwordRE" required="required">
							</td>
						</tr>
						<tr>
							<th width="150">이 름</th>
							<td width="200">   
							<input type="text" id="name" name="name">
							</td>
						</tr>
						<tr>
							<th width="150">주 소</th>
							<td width="200">   
							<input type="text" id="address" name="address" >
							</td>
						</tr>
						<tr>
							<th width="150">연락처</th>
							<td width="200">   
							<input type="text" id="tel" name="tel" >
							</td>
						</tr>
					</table>
				</div><br>
				<input type="hidden" id="adthor" name="author" value="USER">
				<input type="button" value="회원가입" onclick="Comparison()" > &nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">		
			
			</form>
		</div>
	</div>
</body>
</html>