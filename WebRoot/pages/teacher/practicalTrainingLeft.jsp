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
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="../images/leftico01.png" /></span>实训
    </div>
    	<ul class="menuson">
        
        <li><cite></cite><a href="practicalTraining_practicalTrainingTask.action" target="rightFrame">实训管理</a><i></i></li>
        <li><cite></cite><a href="practicalTraining_template.action" target="rightFrame">模板管理</a><i></i></li>
        </ul>    
    </dd>
        
    <!-- <dd>
    <div class="title">
    <span><img src="../images/leftico01.png" /></span>考勤
    </div>
    	<ul class="menuson">
        
        <li><cite></cite><a href="attendanceAction_queryAttendance.action" target="rightFrame">考勤管理</a><i></i></li>
        <li><cite></cite><a href="attendanceAction_queryAttendanceList.action" target="rightFrame">考勤详细查询</a><i></i></li>
        </ul>    
    </dd> -->
        
    
    <dd>
    <div class="title">
    <span><img src="../images/leftico02.png" /></span>考试管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#">编辑内容</a><i></i></li>
        <li><cite></cite><a href="#">发布信息</a><i></i></li>
        <li><cite></cite><a href="#">档案列表显示</a><i></i></li>
        </ul>     
    </dd>
    </dl>
    
</body>
</html>
