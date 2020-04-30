<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title></head>
<body>
    <h1>인증을 무사히 완료하였습니다.</h1>
    <span>ID : ${userID}</span>

    <sec:authorize access="isAuthenticated()">
        <a href="#" onclick="document.getElementById('logout').submit();">로그아웃</a>
    </sec:authorize>

    <form id="logout" action="/logout" method="POST">
        <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
    </form>
</body>
</html>