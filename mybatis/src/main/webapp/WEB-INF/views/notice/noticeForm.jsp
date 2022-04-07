<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
</head>
<body>
	<div align="center">
		<form id="frm" action="noticeInsert.do" method="post">
			<div>
				<h1>공지사항 작성</h1>
			</div>
			<div>
				<table border="1">
					<tr>
						<input type="hidden" id="id" name="id" value="${notice.id }">
						<input type="hidden" id="name" name="name" value="${notice.name }">
					</tr>

					<tr>
						<th>제 목</th>
						<td colspan="5"><input type="text" id="title" name="title">
						</td>
					</tr>

					<tr>
						<th>내 용</th>
						<td colspan="5"><textarea rows="5" cols="36" id="contents"
								name="contents"></textarea></td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<input type="submit" value="저 장"> &nbsp;&nbsp;&nbsp; <input
					type="reset" value=" 취 소"> &nbsp;&nbsp;&nbsp;
			</div>
		</form>
	</div>
</body>
</html>