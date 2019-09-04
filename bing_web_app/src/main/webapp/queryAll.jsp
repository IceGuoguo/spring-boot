<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>

<%--当前用户：${sessionScope.loginuser.username}--%>
<%--<img src="${pageContext.request.contextPath}/upload/${sessionScope.loginuser.image}" width="40px" height="30px"/>--%>

<h2>分页查询所有用户</h2>
<form action="${pageContext.request.contextPath}/bingApp/showAll" method="post">
<table border="1px" cellspacing="0" align="center">
    <tr align="center" bgcolor="pink">
        <td>id</td>
        <td>name</td>
        <td>sex</td>
        <td>password</td>
        <td>birthday</td>
        <td>photo</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr align="center">
            <td><input type="checkbox" name="ids" value="${user.id}">${user.id}</td>
            <td>${user.name}</td>
            <td>${user.sex}</td>
            <td>${user.password}</td>
            <td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/> </td>
            <td><a href="${pageContext.request.contextPath}/bingApp/deleteUserByIds?id=${user.id}">删除</a>|
                <a href="${pageContext.request.contextPath}/bingApp/queryUserById?id=${user.id}">修改</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7"><input type="submit" value="删除所选" /></td>
    </tr>
</table>

</form>

<h2><a href="${pageContext.request.contextPath}/addEmployee.jsp">添加一个员工</a></h2>

</body>
</html>
