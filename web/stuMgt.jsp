<%--
  Created by IntelliJ IDEA.
  User: CP183
  Date: 2019/12/24
  Time: 14:09
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
    <form action="${pageContext.request.contextPath}/addStu" method="post" id="formId">
        <table>
            <tr>
                <td>学生学号</td>
                <td>
                    <input type="text" name="sid">
                </td>
            </tr>
            <tr>
                <td>学生姓名</td>
                <td><input type="text" name="sname"></td>
            </tr>
            <tr>
                <td>学生密码</td>
                <td><input type="password" name="spwd"></td>
            </tr>
            <tr>
                <td>所在班级</td>
                <td>
                    <select name="grade">
                        <option disabled selected="selected" value="7000">---请选择---</option>
                        <option value="7001">大一</option>
                        <option value="7002">大二</option>
                        <option value="7003">大三</option>
                        <option value="7004">大四</option>
                    </select>
                    <select name="sclass">
                        <option disabled selected="selected">---请选择---</option>
                    </select>
                </td>
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
        <th>学生学号</th>
        <th>学生姓名</th>
        <th>所在班级</th>
        <th>操作</th>
    </tr>
    <c:if test="${not empty students}">
        <c:forEach items="${students}" var="sm" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${sm.sid}</td>
                <td>${sm.sname}</td>
                <td>${sm.sclassVal}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/getStu?id=${sm.id}">修改</a>
                    || <a href="${pageContext.request.contextPath}/deleteStu?id=${sm.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty students}">
        <tr>
            <td colspan="5">没有数据</td>
        </tr>
    </c:if>
</table>
</body>
<script src="static/js/jquery-1.11.0.min.js"></script>
<script src="static/js/jquery-validation-1.14.0_jquery.validate.js"></script>
<script src="static/js/jquery-validation-1.14.0_messages_zh.js"></script>
<script type="application/javascript">
    $(function () {
        $("#formId").validate({
            rules: {
                // username: "required",
                // password: {
                //     required: true,
                //     digits: true
                // }, password2: {
                //     required: true,
                //     equalTo: "#password"
                // },
                // sex: "required",
                // address: "required",
                grade: "required",
                sclass: "required"
            },
            messages: {
                // username: "用户名不能为空",
                // password: {
                //     required: "密码不能为空",
                //     digits: "密码只是正整数"
                // }, password2: {
                //     required: "再次输入密码不能为空",
                //     equalTo: "两次密码输入不一致"
                // },
                // sex: {
                //     required: "勾选性别"
                // },
                // address: "请填地址",
                grade: "年级未选择",
                sclass: "班级未选择"
            },
            errorPlacement: function (error, element) {
                error.appendTo(element.parent());
            }
        });
    });

    $(function () {
        $("[name=\"grade\"]").change(function () {
            let gradeVal = $("[name=\"grade\"]").val();
            let arrayClass = new Array();
            let arrayVal = new Array();

            if (gradeVal == "7001") {
                arrayClass = new Array("java51", "java52", "java53");
                arrayVal = new Array(50001, 50002, 50003);
            }

            if (gradeVal == "7002") {
                arrayClass = new Array("java61", "java62", "java63");
                arrayVal = new Array(60001, 60002, 60003);
            }

            if (gradeVal == "7003") {
                arrayClass = new Array("java71", "java72", "java73");
                arrayVal = new Array(70001, 70002, 70003);
            }

            if (gradeVal == "7004") {
                arrayClass = new Array("java81", "java82", "java83");
                arrayVal = new Array(80001, 80002, 80003);
            }

            let clas = $("[name=\"sclass\"]");
            clas.html("<option disabled selected=\"selected\" value='8000'>---请选择---</option>");
            let classVal = $(arrayClass);
            let sVal = $(arrayVal);

            classVal.each(function (i, c) {
                clas.append("<option value='" + arrayVal[i] + "'>" + c + "</option>");
            });
        });
    });
</script>
</html>
