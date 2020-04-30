<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title></head>
<body>
    <h2>로그인</h2><br/><br/>
    <a href="/oauth2/authorization/kakao" class="btn_social" data-social="kakao">카카오톡 로그인</a><br/>
    <sec:authorize access="isAuthenticated()">
        사용자인증됨
    </sec:authorize>
</body>
</html>