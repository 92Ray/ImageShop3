<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
<link rel="stylesheet" href="/css/auth.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<jsp:include page="/WEB-INF/views/common/menu.jsp" />

<div class="auth_logout">
    <form method="post" action="/auth/logout">
        <table>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit"><spring:message code="action.log" /></button>
                </td>
            </tr>
        </table>
        <sec:csrfInput />
    </form>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>