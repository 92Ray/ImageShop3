<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" href="/css/header.css">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/header.css">

<!-- 헤더 전체가 홈 링크 -->
<a href="/" class="app-homebar">
    <div class="app-homebar__content">
        <span class="app-homebar__title">
            <spring:message code="header.home"/>
        </span>
    </div>
</a>