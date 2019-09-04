<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>

<%--当前用户：${sessionScope.loginuser.username}--%>
<%--<img src="${pageContext.request.contextPath}/upload/${sessionScope.loginuser.image}" width="40px" height="30px"/>--%>

<h2>用户登录</h2>
<form action="${pageContext.request.contextPath}/bingApp/login" method="get">
    用户名：<input type="text" name="name" /><br/>
    密码：<input type="text" name="password" /><br/>
    <input type="submit" value="登录" />
</form>

<h2><a href="${pageContext.request.contextPath}/register.jsp">用户注册</a></h2>

</body>
</html>
