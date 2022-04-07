<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 페이지</title>

<script type="text/javascript">
//여기서 n값은 CallNotice() 함수가 가지고온 변수값을 임시로 저장하고 있는 임시 변수이다.
//고로 n값이 없으면 가지온값이 없기때문에 문제가 생긴다. 
	function CallNotice(R) {  
		frm.nid.value = R;  //frm.nid 라는 값을 찾아서 그 벨류값을 R(${notice.nid}) 로 지정한다.
		frm.submit();
	}

</script>
</head>
<jsp:include page="../home/header.jsp" />
<body>
	<div align="center">
		<div>
			<h1>공지사항 안내</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="200">글번호</th>
					<th width="200">작성자</th>
					<th width="200">제 목</th>
					<th width="200">작성일자</th>
					<th width="200">조회수</th>
				</tr>
				<c:forEach items="${notices }" var="notice">
					<tr onmouseover='this.style.background="#fcecae";'
						onmouseleave='this.style.background="#FFFFFF";'
						onclick="CallNotice(${notice.nid})">
						<!--CallNotice()함수 안에 ${notice.nid} 값을 담아서 가지고 이동한다 -->
						<!-- tr테그안에 함수로 감싸서 td 태그 어디를 클릭하든 함수가 작동된다. -->
						<td align="center">${notice.nid }</td>
						<td align="center">${notice.name }</td>
						<td align="center">${notice.title }</td>
						<td align="center">${notice.writedate }</td>
						<td align="center">${notice.hit }</td>
					</tr>
				</c:forEach>
			</table>
		</div><br>
	<div>
		<c:if test="${author == 'ADMIN' }">
		<input type="button" onclick="location.href='noticeForm.do'" value="글작성"> &nbsp;&nbsp; 
		</c:if>
		<input type="button" onclick="location.href='home.do'"value="메인으로">
	</div>
	<div>
		<!-- hidden 을사용해서 숨겨서 페이지호출을 할수 있도록했다-->
		<form id="frm" action="noticeCon.do" method="post">
			<input type="hidden" id="nid" name="nid">
		</form>
	</div>
	</div>
	
</body>
</html>