<%--
  Created by IntelliJ IDEA.
  User: CP183
  Date: 2019/12/23
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>学生成绩管理系统登录</title>
    <link rel="stylesheet" href="static/css/login.css">
</head>
<body>
<div id="tab">
    <ul class="tab_menu">
        <li class="selected">学生登录</li>
        <li>导师登录</li>
        <li>教务登录</li>
    </ul>
    <div class="tab_box">
        <!-- 学生登录开始 -->
        <div>
            <div class="stu_error_box"></div>
            <form action="${pageContext.request.contextPath}/loginStudent" method="post" class="">
                <div id="username">
                    <label>学&nbsp;&nbsp;&nbsp;号：</label>
                    <input type="text" id="stu_username_hide" name="username" value="输入学号" nullmsg="学号不能为空！"
                           datatype="s6-18" errormsg="学号范围在6~18个字符之间！" sucmsg="学号验证通过！"/>
                    <!--ajaxurl="demo/valid.jsp"-->
                </div>
                <div id="password">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" id="stu_password_hide" name="password" value="输入密码" nullmsg="密码不能为空！"
                           datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
                </div>
                <div id="remember">
                    <input type="checkbox" name="remember">
                    <label>记住密码</label>
                </div>
                <div id="login">
                    <button type="submit">登录</button>
                </div>
            </form>
        </div>
        <!-- 学生登录结束-->
        <!-- 导师登录开始-->
        <div class="hide">
            <div class="tea_error_box"></div>
            <form action="${pageContext.request.contextPath}/loginTeacher" method="post" class="">
                <div id="tusername">
                    <label>教工号：</label>
                    <input type="text" id="tea_username_hide" name="username" value="输入教工号" nullmsg="教工号不能为空！"
                           datatype="s6-18" errormsg="教工号范围在6~18个字符之间！" sucmsg="教工号验证通过！"/>
                    <!--ajaxurl="demo/valid.jsp"-->
                </div>
                <div id="tpassword">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" id="tea_password_hide" name="password" value="输入密码" nullmsg="密码不能为空！"
                           datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
                </div>
                <div id="tremember">
                    <input type="checkbox" name="remember">
                    <label>记住密码</label>
                </div>
                <div id="tlogin">
                    <button type="submit">登录</button>
                </div>
            </form>
        </div>
        <!-- 导师登录结束-->
        <!-- 教务登录开始-->
        <div class="hide">
            <div class="sec_error_box"></div>
            <form action="${pageContext.request.contextPath}/loginUser" method="post" class="">
                <div id="jusername">
                    <label>教务号：</label>
                    <input type="text" id="sec_username_hide" name="username" value="输入教务号" nullmsg="教务号不能为空！"
                           datatype="s6-18" errormsg="教务号范围在6~18个字符之间！" sucmsg="教务号验证通过！"/>
                    <!--ajaxurl="demo/valid.jsp"-->
                </div>
                <div id="jpassword">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" id="sec_password_hide" name="password" value="输入密码" nullmsg="密码不能为空！"
                           datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
                </div>
                <div id="jremember">
                    <input type="checkbox" name="remember">
                    <label>记住密码</label>
                </div>
                <div id="jlogin">
                    <button type="submit">登录</button>
                </div>
            </form>
        </div>
        <!-- 教务登录结束-->
    </div>
</div>
<div class="bottom">©2014 Leting <a href="javascript:;" target="_blank">关于</a> <span>京ICP证030173号</span> More Templates
    <a href="http://www.cssmoban.com/" target="_blank" title="CP">CP</a> - Collect from <a
            href="http://www.cssmoban.com/" title="网页模板" target="_blank">CP</a><img width="13" height="16"
                                                                                    src="static/images/copy_rignt_24.png"/>
</div>
<div class="screenbg">
    <ul>
        <li><a href="javascript:;"><img src="static/img/0.jpg"></a></li>
        <li><a href="javascript:;"><img src="static/img/1.jpg"></a></li>
        <li><a href="javascript:;"><img src="static/img/2.jpg"></a></li>
    </ul>
</div>
</body>
<script type="text/javascript" src="static/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="static/js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="static/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var $tab_li = $('#tab ul li');
        $tab_li.hover(function () {
            $(this).addClass('selected').siblings().removeClass('selected');
            var index = $tab_li.index(this);
            $('div.tab_box > div').eq(index).show().siblings().hide();
        });
    });
</script>
<script type="text/javascript">
    $(function () {
        /*学生登录信息验证*/
        $("#stu_username_hide").focus(function () {
            var username = $(this).val();
            if (username == '输入学号') {
                $(this).val('');
            }
        });
        $("#stu_username_hide").focusout(function () {
            var username = $(this).val();
            if (username == '') {
                $(this).val('输入学号');
            }
        });
        $("#stu_password_hide").focus(function () {
            var username = $(this).val();
            if (username == '输入密码') {
                $(this).val('');
            }
        });
        $("#stu_password_hide").focusout(function () {
            var username = $(this).val();
            if (username == '') {
                $(this).val('输入密码');
            }
        });
        $(".stu_login_error").Validform({
            tiptype: function (msg, o, cssctl) {
                var objtip = $(".stu_error_box");
                cssctl(objtip, o.type);
                objtip.text(msg);
            },
            ajaxPost: true
        });
        /*导师登录信息验证*/
        $("#tea_username_hide").focus(function () {
            var username = $(this).val();
            if (username == '输入教工号') {
                $(this).val('');
            }
        });
        $("#tea_username_hide").focusout(function () {
            var username = $(this).val();
            if (username == '') {
                $(this).val('输入教工号');
            }
        });
        $("#tea_password_hide").focus(function () {
            var username = $(this).val();
            if (username == '输入密码') {
                $(this).val('');
            }
        });
        $("#tea_password_hide").focusout(function () {
            var username = $(this).val();
            if (username == '') {
                $(this).val('输入密码');
            }
        });
        $(".tea_login_error").Validform({
            tiptype: function (msg, o, cssctl) {
                var objtip = $(".tea_error_box");
                cssctl(objtip, o.type);
                objtip.text(msg);
            },
            ajaxPost: true
        });
        /*教务登录信息验证*/
        $("#sec_username_hide").focus(function () {
            var username = $(this).val();
            if (username == '输入教务号') {
                $(this).val('');
            }
        });
        $("#sec_username_hide").focusout(function () {
            var username = $(this).val();
            if (username == '') {
                $(this).val('输入教务号');
            }
        });
        $("#sec_password_hide").focus(function () {
            var username = $(this).val();
            if (username == '输入密码') {
                $(this).val('');
            }
        });
        $("#sec_password_hide").focusout(function () {
            var username = $(this).val();
            if (username == '') {
                $(this).val('输入密码');
            }
        });
        $(".sec_login_error").Validform({
            tiptype: function (msg, o, cssctl) {
                var objtip = $(".sec_error_box");
                cssctl(objtip, o.type);
                objtip.text(msg);
            },
            ajaxPost: true
        });
    });
</script>
<script type="text/javascript">
    $(function () {
        $(".screenbg ul li").each(function () {
            $(this).css("opacity", "0");
        });
        $(".screenbg ul li:first").css("opacity", "1");
        var index = 0;
        var t;
        var li = $(".screenbg ul li");
        var number = li.size();

        function change(index) {
            li.css("visibility", "visible");
            li.eq(index).siblings().animate({opacity: 0}, 3000);
            li.eq(index).animate({opacity: 1}, 3000);
        }

        function show() {
            index = index + 1;
            if (index <= number - 1) {
                change(index);
            } else {
                index = 0;
                change(index);
            }
        }

        t = setInterval(show, 8000);
        //根据窗口宽度生成图片宽度
        var width = $(window).width();
        $(".screenbg ul img").css("width", width + "px");
    });
</script>
</html>