<%--
  Created by IntelliJ IDEA.
  User: CP183
  Date: 2019/12/26
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        a {
            margin: auto;
        }

        table {
            margin: auto;
            width: 50%;
        }

        td {
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/addUser" method="post" id="formId">
        <table>
            <tr>
                <td>教务账号</td>
                <td>
                    <input type="text" name="uid">
                </td>
            </tr>
            <tr>
                <td>教务姓名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>教务密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="添加"></td>
            </tr>
        </table>
    </form>
</div>
<table>
    <tr>
        <th>序号</th>
        <th>教务账号</th>
        <th>教务姓名</th>
        <th>操作</th>
    </tr>
    <c:if test="${not empty users}">
        <c:forEach items="${users}" var="um" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${um.uid}</td>
                <td>${um.username}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/getUser?id=${um.id}">修改</a>
                    || <a href="${pageContext.request.contextPath}/deleteUser?id=${um.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty users}">
        <tr>
            <td colspan="5">没有数据</td>
        </tr>
    </c:if>
</table>
</body>
</html>
