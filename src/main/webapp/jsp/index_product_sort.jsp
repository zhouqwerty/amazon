<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="p_category" >
	<h2>商品分类</h2>


	<c:set var="categoryInfo" value="${requestScope.categoryInfo }"></c:set>

	<c:forEach items="${categoryInfo }" var="c">
		<dl>
			<dt>
				<a href="category?cate=parent&hpcId=${c[0].HPC_ID  }">${c[0].HPC_NAME  }</a>
			</dt>
			<c:forEach items="${c[1] }" var="category">
				<dd>
					<a href="category?cate=child&hpcId=${category.HPC_ID }">${category.HPC_NAME }</a>
				</dd>
			</c:forEach>
		</dl>
	</c:forEach>
</div>


