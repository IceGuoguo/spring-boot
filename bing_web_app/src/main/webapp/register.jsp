<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>

<%--当前用户：${sessionScope.loginuser.username}--%>
<%--<img src="${pageContext.request.contextPath}/upload/${sessionScope.loginuser.image}" width="40px" height="30px"/>--%>

<h2>用户注册</h2>
<form action="${pageContext.request.contextPath}/bingApp/register" method="post">
    用户名：<input type="text" name="name" /><br/>
    密码：<input type="text" name="password" /><br/>
    性别：<input type="text" name="sex" /><br/>
    生日：<input type="date" name="birthday" /><br/>
    头像：<input type="text" name="photo" /><br/>
    <input type="submit" value="注册" />
    <input type="reset" value="重新填写" />
</form>
</body>
</html>
