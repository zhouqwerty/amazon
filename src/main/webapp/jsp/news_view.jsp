<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 新闻显示</title>
<link href="${pageContext.request.contextPath}/css/customcss/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/customcss/adv.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/customcss/style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/framejs/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/customjs/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/customjs/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/customjs/index.js"></script>

</head>
<body>
<%@ include file="index_top.jsp"  %>
<div id="position" class="wrap">
	您现在的位置：<a href="ProductServlet">亚马逊</a> &gt; 阅读新闻
</div>
<div id="main" class="wrap">
	<div class="left-side">
		<%@ include file="index_news.jsp" %>
	</div>
	<div id="news" class="right-main">
		<c:set var="news" value="${requestScope.newsInfo }"></c:set>
		<h1>标题：${news.hnTitle }</h1>
		<div class="content">
			<p style="text-align: right;">创建时间：${news.hnCreateTime }</p>
			内容：${news.hnContent }			
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2016 上海海文 All Rights Reserved.
</div>
</body>
</html>

