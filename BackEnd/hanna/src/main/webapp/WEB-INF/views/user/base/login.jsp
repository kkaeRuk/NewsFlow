<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>NewsFlow</title>
    </head>
    <body>
        <c:if test="${userId eq null}">
            <a href="https://kauth.kakao.com/oauth/authorize?client_id=d6c50ddf594dc4fbfa454767e6a88cb2&redirect_uri=http://localhost:8080/user/kakao/login&response_type=code"><img src="/img/kakao_account_login_btn_medium_narrow.png"></a>
        </c:if>
        <c:if test="${userId ne null}">
            <h1>${userId} 로그인성공</h1>
            <input type="button" value="로그아웃" onclick="location.href='/user/kakao/logout'">
        </c:if>
    </body>
</html>