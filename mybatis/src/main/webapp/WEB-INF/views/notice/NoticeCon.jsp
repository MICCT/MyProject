<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 세부내용</title>

<script type="text/javascript">
	function CallCho(or) {
		if(or == 'A'){
			frm.action="noticeEdit.do"; 
		}else{
			frm.action="noticeDeleto.do";
		}
		frm.submit();
	}
</script>
</head>
<jsp:include page="../home/header.jsp" />
<body>
	<div align="center">
		<form id="frm" method="post" action="">
			<div><h1>공지사항 자세히</h1></div>
			<div>
				<table border="1">
					<tr>
						<th width="120">글번호</th>
						<td width="100" align="center">${notice.nid }</td>
						<th width="120">작성자</th>
						<td width="100" align="center">${notice.name }</td>
						<th width="120">작성일자</th>
						<td width="100" align="center">${notice.writedate }</td>
						<th width="120">조회수</th>
						<td width="100" align="center">${notice.hit }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="7"><textarea rows="2" cols="110" id="title"
								name="title">${notice.title }</textarea></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="7"><textarea rows="7" cols="110" id="contents"
								name="contents">${notice.contents }</textarea></td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<input type="button" onclick="location.href=''" value="목록으로">&nbsp;&nbsp; 
				<input type="button" onclick="CallCho('A')" value="글 수정"> &nbsp;&nbsp; 
				<input type="button"onclick="CallCho('B')" value="글 삭제">
			</div>
			<input type="hidden" id="nid" name="nid" value="${notice.nid }">
		</form>
	</div>
</body>
</html>