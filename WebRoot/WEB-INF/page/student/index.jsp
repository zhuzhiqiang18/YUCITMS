<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
	</head>
	<body>
			<iframe src="student_top.action" width="100%" height="80px" scrolling="no" frameborder="0"></iframe>
			<iframe src="student_left.action" width="300px" height="100%" scrolling="no" frameborder="0"></iframe>
			<iframe src="student_main.action" width="60%" height="100%" scrolling="no" frameborder="0" name="main"></iframe>
	</body>
</html>
