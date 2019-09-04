<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>

<%--当前用户：${sessionScope.loginuser.username}--%>
<%--<img src="${pageContext.request.contextPath}/upload/${sessionScope.loginuser.image}" width="40px" height="30px"/>--%>

<h2>查询所有员工</h2>
<form action="${pageContext.request.contextPath}/ems/batchDeleteEmployee" method="post">
<table border="1px" cellspacing="0" align="center">
    <tr align="center" bgcolor="pink">
        <td>id</td>
        <td>name</td>
        <td>salary</td>
        <td>age</td>
        <td>departmentId</td>
        <td>hireDate</td>
        <td>option</td>
    </tr>
    <c:forEach items="${employees}" var="emp">
        <tr align="center">
            <td><input type="checkbox" name="ids" value="${emp.id}">${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.salary}</td>
            <td>${emp.age}</td>
            <td>${emp.departmentId}</td>
            <td><fmt:formatDate value="${emp.hireDate}" pattern="yyyy-MM-dd"/> </td>
            <td><a href="${pageContext.request.contextPath}/ems/deleteEmployee?id=${emp.id}">删除</a>|
                <a href="${pageContext.request.contextPath}/ems/queryOne?id=${emp.id}">修改</a></td>
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
