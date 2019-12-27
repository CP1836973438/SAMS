<%--
  Created by IntelliJ IDEA.
  User: CP183
  Date: 2019/12/26
  Time: 11:05
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
            width: 80%;
        }

        td {
            text-align: center;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>序号</th>
        <th>学生学号</th>
        <th>学生姓名</th>
        <th>所在班级</th>
        <th>语文成绩</th>
        <th>数学成绩</th>
        <th>英语成绩</th>
        <th>操作</th>
    </tr>
    <c:if test="${not empty students}">
        <c:forEach items="${students}" var="sm" varStatus="vs">
            <form action="${pageContext.request.contextPath}/updateStuGrade" method="post">
                <tr>
                    <td>${vs.count}</td>
                    <td><input type="hidden" name="id" value="${sm.id}"></td>
                    <td>${sm.sid}</td>
                    <td>${sm.sname}</td>
                    <td>${sm.sclassVal}</td>
                    <td><input type="text" name="chinese" value="${sm.chinese}"></td>
                    <td><input type="text" name="math" value="${sm.math}"></td>
                    <td><input type="text" name="english" value="${sm.english}"></td>
                    <td><input type="hidden" name="sgrade" value="${sm.sgrade}"></td>
                    <td>
                        <input type="submit" value="修改">
                    </td>
                </tr>
            </form>
        </c:forEach>
    </c:if>
    <c:if test="${empty students}">
        <tr>
            <td colspan="8">没有数据</td>
        </tr>
    </c:if>
</table>
</body>
</html>
