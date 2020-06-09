<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet"
          href="<s:url value='css/header.css'/>"/>
</head>
<body background="img/bg/bg_inboxFile.jpg">
<!--导航栏开始-->

<nav class="navbar navbar--inbox inbox-navbar-default" style="background-color: transparent">
    <div class="container" style="position: relative;">
        <a href="main.jsp" class="brand" title="收件夹 - 快速创建收件夹">
            <img class="brand--logo" width="40" height="40" src="upFile/logo0.png">
            <div class="brand--title">
                <h1>收件夹</h1>
                <h2 class="hidden-xs">快速创建收件夹，向多人收取文件</h2>
            </div>
        </a>
        <ul class="header--nav">
            <li class="dropdown">
                <a id="user_menu" class="user_menu_btn" data-toggle="dropdown">
                    <img id="userHeadImg"
                         src="http://img.mp.itc.cn/upload/20170724/cf678e09eb384401aa616ba134126357_th.jpg"
                         width="30" height="30" class="img-circle"/>
                </a>
                <!--下拉框-->

                <ul class="dropdown-menu pull-left" role="menu" aria-labelledby="user_menu">
                    <li role="presentation">
                        <a role="menuitem" href="<s:url value='personal.jsp'/>" tabindex="-1" href="#"
                           style="color: #757575;"><i class="glyphicon glyphicon-user"></i> 个人中心
                        </a>
                    </li>
                    <li role="presentation">
                        <a role="menuitem" tabindex="-1" href="#" style="color: #757575;"><i
                                class="glyphicon glyphicon-log-out"></i> 退出登录
                        </a>
                    </li>
                </ul>
                ${user.name }
            </li>

        </ul>

    </div>

</nav>
<!--导航栏结束-->
</body>

</html>