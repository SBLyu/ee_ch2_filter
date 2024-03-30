<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mad.nthu.ch2_filter.AccountException" %>
<%@ page import="mad.nthu.ch2_filter.BusinessException" %>

<%
	String action=request.getParameter("action");

	if("businessException".equals(action)){
		throw new BusinessException("業務操作失敗。");
	}else if("accountException".equals(action)){
		throw new AccountException("您需要登入後再進行此操作。");
	}else if("exception".equals(action)){
		Integer.parseInt("Oslo");
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<a href="${ pageContext.request.requestURI }?action=businessException">test BusinessException</a><br>
		<a href="${ pageContext.request.requestURI }?action=accountException">test AccountException</a><br>
		<a href="${ pageContext.request.requestURI }?action=exception">test Exception</a><br>
	</body>
</html>