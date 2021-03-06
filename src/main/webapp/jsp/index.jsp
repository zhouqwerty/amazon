<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊-首页</title>
<link href="${pageContext.request.contextPath}/lib/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/customcss/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/customcss/adv.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/customjs/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/customjs/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/customjs/index.js"></script>
</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="middle">
		<div class="p_left">
			<!--商品分类-->
			<%@ include file="index_product_sort.jsp"%>
			<!--商品分类结束-->

			<div class="pre_look">
				<h3>最近浏览</h3>
				<dl>
					<c:forEach items="${sessionScope.viewedProduct }" var="p" end="3">
						<dt>
							<img style="width: 54px; height: 54px;" src="${p.hpFileName }" />
						</dt>
						<dd>
							<a href="pview?pId=${p.HP_ID}">${p.HP_NAME}</a>
						</dd>
					</c:forEach>
				</dl>
			</div>
		</div>

		<div class="p_center">
			<div id="wrapper">
				<div id="focus">
					<ul>
						<li><a href="#"><img src="../images/use/carousel/c1.jpg" /></a></li>
						<li><a href="#"><img src="../images/use/carousel/c2.jpg" /></a></li>
						<li><a href="#"><img src="../images/use/carousel/c3.jpg" /></a></li>
						<li><a href="#"><img src="../images/use/carousel/c4.jpg" /></a></li>
						<li><a href="#"><img src="../images/use/carousel/c5.jpg" /></a></li>
					</ul>
				</div>
			</div>
			<div class="p_list">
				<div class="p_info">
					<img src="../images/icon_sale.png"/>商品列表
				</div>
			</div>

			<ul class="product2">
				<c:if test="${sessionScope.pager.pageCount==0}">
					<h4>找不到您搜索的商品！</h4>
				</c:if>
				<c:set value="${requestScope.list}" var="products"></c:set>
				<c:forEach items="${products}" var="p">
					<li>
						<dl>
							<dt>
								<a href="pview?pId=${p.HP_ID }" target="_self"><img
									src="${p.HP_FILE_NAME }" /></a>
							</dt>
							<dd class="title">
								<a href="pview?pId=${p.HP_ID}" target="_self">${p.HP_NAME }</a>
							</dd>
							<dd class="price">￥${p.HP_PRICE}</dd>
						</dl>
					</li>

				</c:forEach>


			</ul>

			<!--分页-->
			<div class="pager">
				<ul>
					<ul>
						<li><a href="javascript:lastPage()" id="lastPage">上一页</a></li>
						<c:forEach items="${requestScope.pager.groupList}" var="pl">
							<li><a
								href="ref?src=${requestScope.pager.source}&page=${pl}&hpcId=${requestScope.pager.hpc_id}">${pl}</a></li>
						</c:forEach>
						<li><a href="javascript:nextPage()" id="nextPage">下一页</a></li>
					</ul>
				</ul>
				<input type="hidden" id="source"
					value="${requestScope.pager.source}" /><input type="hidden"
					id="hpcId" value="${requestScope.pager.hpc_id}" /> <input
					type="hidden" id="totalPage"
					value="${requestScope.pager.totalPage}" /> <input
					type="hidden" id="currentPage"
					value="${requestScope.pager.currentPage}" /> <input
					type="hidden" id="queryName"
					value="${requestScope.pager.qname}" />
			</div>
		</div>

		<div id="p_right">
			<%@ include file="index_news.jsp"%>
			<%@ include file="hotproduct.jsp"%>
		</div>
	</div>

	<div id="foot">Copyright © 2016 上海海文 All Rights Reserved.</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/framejs/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/framejs/bootstrap.js"></script>
</body>
</html>

