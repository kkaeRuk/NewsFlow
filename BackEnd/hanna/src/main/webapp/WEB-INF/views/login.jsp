<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title></head>
<body>
    <h2>로그인</h2><br/><br/>
    <%--<a href="javascript:;" class="btn_social" data-social="facebook">페이스북 로그인</a><br/>--%>
    <%--<a href="javascript:;" class="btn_social" data-social="google">구글 로그인</a><br/>--%>
    <a href="/oauth2/authorization/kakao" class="btn_social" data-social="kakao">카카오톡 로그인</a><br/>
    <sec:authorize access="isAuthenticated()">
        사용자인증됨
    </sec:authorize>
    <%--<a href="javascript:;" class="btn_social" data-social="naver">네이버 로그인</a><br/>--%>

    <%--<script>--%>
        <%--let socials = document.getElementsByClassName("btn_social");--%>
        <%--for (let social of socials) {--%>
            <%--social.addEventListener('click', function () {--%>
                <%--let socialType = this.getAttribute('data-social');--%>
                <%--location.href = "/oauth2/authorization/" + socialType;--%>
            <%--})--%>
        <%--}--%>
    <%--</script>--%>
</body>
</html>