﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(${pageContext.request.contextPath}/excellentCourseStyle/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="lessonleft.html" target="leftFrame" class="selected"><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/icon01.png" title="课程管理" /><h2>课程管理</h2></a></li>
    <li><a href="manage_examLeft.action" target="leftFrame"><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/icon02.png" title="考试管理" /><h2>考试管理</h2></a></li>
    <li><a href="${pageContext.request.contextPath}/pages/teacher/practicalTrainingLeft.jsp"  target="leftFrame"><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/icon03.png" title="实训管理" /><h2>实训管理</h2></a></li>
    <li><a href="${pageContext.request.contextPath}/pages/teacher/attendanceLeft.jsp"  target="leftFrame"><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/icon04.png" title="考勤管理" /><h2>考勤管理</h2></a></li>
    <li><a href="communicationleft.html" target="leftFrame"><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/icon05.png" title="交流管理" /><h2>交流管理</h2></a></li>
    <li><a href="basicsleft.html"  target="leftFrame"><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/icon06.png" title="系统配置" /><h2>基础配置</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="../../images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="login.html" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>admin</span>
    <i>消息</i>
    <b>5</b>
    </div>    
    
    </div>

</body>
</html>
