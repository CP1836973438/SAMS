<%--
  Created by IntelliJ IDEA.
  User: CP183
  Date: 2019/12/26
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
<form action="${pageContext.request.contextPath}/updateUser" method="post" id="formId">
    <table>
        <tr>
            <td>教务账号</td>
            <td>
                <input type="hidden" name="id" value="${ut.id}">
                <input type="text" name="uid" value="${ut.uid}">
            </td>
        </tr>
        <tr>
            <td>教务姓名</td>
            <td><input type="text" name="username" value="${ut.username}"></td>
        </tr>
        <tr>
            <td>教务密码</td>
            <td><input type="password" name="password" value="${ut.password}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>

