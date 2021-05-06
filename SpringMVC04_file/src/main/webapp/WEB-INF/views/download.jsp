<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>download</title>
</head>
<body>
	
	file : ${fileObj.name }<br>
	desc : ${fileObj.desc }<br>
	
	<form action="download" method="post">
		<input type="hidden" name="name" value="${fileObj.name }">
		<input type="submit" value="download">
	</form>
	
	<!-- 
		tomcat web.xml 확인!	- (Servers-Tomcat v9.0Server at localhost-config-web.xml) / session-timeout은 세션은 30분동안 유지
		★ mime-type (Multipurpose Internet Mail Extension)
		데이터가 어떤 종류의 stream인지 나타내주는 프로토콜 (request header에 지정!)
		(요청하고 응답할때 파일의 종류가 어떤 타입인지 정해주는거)
		text/html 텍스트파일이지만 html이다.-오타내면 다운로드 됨, 응답되는게 어떤앤지 모르니까 화면에 뿌려질 수 없음..
		
		mime-type 추가!할때
		<mime-mapping>
	        <extension>hwp</extension>
	        <mime-type>application/unknown</mime-type>
	    </mime-mapping>
		
	 -->
	
	
</body>
</html>