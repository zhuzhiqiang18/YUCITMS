<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
	</head>
	<body>
		<div id="left_side">
			<ul>
				<li>
					<a href="examOnline/myExamList.html" target="main">我的考试</a>
				</li>
				<li>
					<a href="myTask/taskList.html" target="main">任务列表</a>
				</li>
				<li>
					<a href="personInfo/studentInfo.html" target="main">个人信息</a>
				</li>
				<li>
					<a href="#">文件管理</a>
				</li>
			</ul>
		</div>
	</body>
</html>
