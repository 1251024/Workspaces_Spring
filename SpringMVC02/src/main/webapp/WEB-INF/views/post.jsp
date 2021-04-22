<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>이름</th>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${dto.addr }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${dto.phone }</td>
		</tr>
	</table>
	
</body>
</html>