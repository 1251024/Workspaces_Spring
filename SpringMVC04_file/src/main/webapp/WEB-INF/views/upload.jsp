<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload</title>
</head>
<body>
	
	
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
	<!-- multipart/form-data: 파일 업로드시 사용 (인코딩 하지 않음) -->
		<h3>uploadForm</h3>
		file<br>
		<input type="file" name="mpfile"><br>
		<p style="color:red; font-weight: bold;">
			<form:errors path="mpfile"></form:errors>
		</p>
		<br>
		<textarea rows="10" cols="40" name="desc"></textarea>
		<br>
		<input type="submit" value="send">
			<!-- 파일과 설명을 받아서 formcontroller로 넘어감 dto의 MultipartFile에 담아서 넘어감, modelAttribute = uploadFile에 담아서 -->
			
	</form:form>
	

	
	<!-- 
	multipartResolver가  multipart/form-data사용할 수 있게해줌
	★enctype(요청하는 데이터의 형식을 지정해줄 수 있음)
	1. application/www-form-urlencoded : (default) 문자들을 encoding/ - content-type으로 지정된걸로 됨(post, get방식으로 폼태그를 통해 넘어가는애)
	2. multipart/form-data : file upload - post만으로 해야함 (get으로 하면 너무 길어져서, 길이의 한계가 있어서)
	3. text/plain : encoding 하지 않음 (기본 문자열로 넘어가겠다.)
	
	------------------------
	
	★spring form tag
		form:form, form:errors, form:input, ...
		form:errors - Errors, BindingResult를 사용할 때, command 객체의 특정 field에서 발생하는 에러메시지 출력
		
		
	------------------------
		url 경로
	urn 이름
	uri 식별자
	
	 -->
	
</body>
</html>