<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	double num = Math.random();
%>
<div id="header">
	<nav class="navbar navbar-default navbar-fixed-top header-nav">
		<div class="login_container">
			<c:set value="${sessionScope.user }" var="user"></c:set>
			<ul class="m_left nav navbar-nav">
				<c:choose>
					<c:when test="${user!=null }">
						<li><a href="#" class="c_red">${user.HU_USER_NAME}</a>&nbsp;&nbsp;&nbsp;</li>
						<li><a href="quit">退出</a>&nbsp;&nbsp;&nbsp;</li>
						<li><a href="register.jsp">请注册</a></li>
					</c:when>

					<c:otherwise>
						<li>
							<button class="btn btn-primary btn-small" data-toggle="modal" data-target="#loginModal">请登录</button>&nbsp;&nbsp;&nbsp
						</li>
						<li><button class="btn btn-primary btn-small" data-toggle="modal" data-target="#registerModal">请注册</button></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<ul class="m_right">
				<c:choose>
					<c:when test="${user!=null }">
						<li><img src="../images/icon_3.png"><a href="shopping" class="c_red">购物车</a></li>
					</c:when>
					<c:otherwise>
						<li><img src="../images/icon_3.png"><a
							href="javascript:tips()" class="c_red">购物车</a></li>
					</c:otherwise>
				</c:choose>
				<li><img src="../images/icon_4.png"><a
					href="javascript:AddFavorite('我的网站',location.href)">收藏</a></li>
				<li><img src="../images/icon_2.png"><a href="guestbook.jsp">留言</a></li>
				<li><img src="../images/icon_1.png"><a href="index.jsp">首页</a></li>
			</ul>
		</div>
	</nav>
	<!-- 登录框 -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">登录</h4>
				</div>
				<div class="modal-body">
					登录信息
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">登录</button>
					<button type="button" class="btn btn-default">找回密码</button>
				</div>
			</div>
		</div>
	</div>
	<div class="logo_search">
		<div class="logo">
			<img src="../images/use/index.png">
		</div>
		<div class="search">
			<input type="text" placeholder="输入宝贝" id="qname" />
			<button class="query_button" onclick="queryProducts()">搜索</button>
		</div>
	</div>
	<div class="nav_bar">
		<div class="nav_bar_container">
			<ul>
				<li><a href="#">商品名称</a></li>
				<c:if test="${requestScope.hotProducts!=null }">
					<c:forEach items="${requestScope.hotProducts }" var="p" end="2">
						<li>|</li>
						<li><a href="pview?pId=${p.hpId }" target="_self">${p.hpName }</a></li>
					</c:forEach>
				</c:if>

				<c:set var="categoryInfo" value="${requestScope.categoryInfo }"></c:set>
				<c:forEach items="${categoryInfo }" var="c" begin="3" end="4">
					<c:forEach items="${c[1] }" var="category" end="4">
						<li>|</li>
						<li><a href="category?cate=child&hpcId=${category.HPC_ID }">${category.HPC_NAME }</a></li>
					</c:forEach>
				</c:forEach>
			</ul>
		</div>
	</div>

	<script type="text/javascript">
		function tips() {
			alert("请先登录亚马逊商城!");
			window.location.href = "login.jsp";
		}

		function AddFavorite(title, url) {
			try {
				window.external.addFavorite(url, title);
			} catch (e) {
				try {
					window.sidebar.addPanel(title, url, "");
				} catch (e) {
					alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请使用Ctrl+D进行添加");
				}
			}
		}
	</script>
</div>
