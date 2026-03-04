<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<link rel="stylesheet" href="/css/menu.css">

<div class="app-menu-flex">
    <!-- 중앙 메뉴 -->
    <div class="menu-center">
        <sec:authorize access="!isAuthenticated()">
            <a href="/board/list" class="nav-link"><spring:message code="board.header.list"/></a>
            <a href="/notice/list" class="nav-link"><spring:message code="menu.notice.member"/></a>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="/codegroup/list" class="nav-link"><spring:message code="menu.codegroup.list"/></a>
                <a href="/codedetail/list" class="nav-link"><spring:message code="menu.codedetail.list"/></a>
                <a href="/user/list" class="nav-link"><spring:message code="menu.user.admin"/></a>
                <a href="/board/list" class="nav-link"><spring:message code="board.header.list"/></a>
                <a href="/notice/list" class="nav-link"><spring:message code="menu.notice.member"/></a>
                <a href="/item/list" class="nav-link"><spring:message code="menu.item.member"/></a>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_MEMBER')">
                <a href="/board/list" class="nav-link"><spring:message code="board.header.list"/></a>
                <a href="/notice/list" class="nav-link"><spring:message code="menu.notice.member"/></a>
                <a href="/item/list" class="nav-link"><spring:message code="menu.item.member"/></a>
                <a href="/coin/charge" class="nav-link"><spring:message code="menu.coin.charge"/></a>
                <a href="/coin/list" class="nav-link"><spring:message code="menu.coin.list"/></a>
                <a href="/useritem/list" class="nav-link"><spring:message code="menu.useritem.list"/></a>
                <a href="/coin/listPay" class="nav-link"><spring:message code="menu.coin.listPay"/></a>
            </sec:authorize>
        </sec:authorize>
    </div>

    <!-- 오른쪽 로그인/회원 버튼 -->
    <div class="menu-right">
        <sec:authorize access="!isAuthenticated()">
            <a href="/user/register" class="nav-link">회원가입</a>
            <a href="/auth/login" class="nav-link">로그인</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <span class="user-info"><sec:authentication property="principal.username"/></span>
            <a href="/auth/logout" class="nav-link">로그아웃</a>
        </sec:authorize>
    </div>
</div>
<hr>