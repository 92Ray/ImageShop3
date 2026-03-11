<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/css/auth_login.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<jsp:include page="/WEB-INF/views/common/menu.jsp" />

<div class="auth_login">
    <form method="post" action="/login">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="checkbox" name="remember-me"> <spring:message code="auth.rememberMe" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit"><spring:message code="action.login" /></button>
                </td>
            </tr>
        </table>
        <sec:csrfInput />
    </form>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>