<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!-- CSS -->
<link rel="stylesheet" href="/css/header.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/layout.css">

<!-- 헤더 / 메뉴 / 푸터 (layout.jsp와 같은 폴더) -->
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<main class="app-content">
    <jsp:include page="${contentPage}" />
</main>

<%@ include file="footer.jsp" %>
