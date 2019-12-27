<%--
  Created by IntelliJ IDEA.
  User: CP183
  Date: 2019/12/24
  Time: 9:44
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

        #div1 {
            width: 200px;
            height: 100px;
            position: absolute;
            left: 1500px;
            top: 20px;
        }

        #div2 {
            margin: 200px auto;
        }
    </style>
</head>
<body>
<div id="div1">
    <a href="${pageContext.request.contextPath}/outLoginUser">退出</a>
</div>
<div id="div2">
    <table>
        <tr>
            <th>学生学号</th>
            <th>学生姓名</th>
            <th>所在班级</th>
            <th>语文成绩</th>
            <th>数学成绩</th>
            <th>英语成绩</th>
        </tr>
        <c:if test="${not empty student}">
            <tr>
                <td>${student.sid}</td>
                <td>${student.sname}</td>
                <td>${student.sclassVal}</td>
                <td>${student.chinese}</td>
                <td>${student.math}</td>
                <td>${student.english}</td>
            </tr>
        </c:if>
        <c:if test="${empty student}">
            <tr>
                <td colspan="6">没有数据</td>
            </tr>
        </c:if>
    </table>
</div>
</body>
</html>
