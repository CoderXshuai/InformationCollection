<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet"
          href="<s:url value='js/bootstrap/css/bootstrap.min.css'/>"/>
    <link rel="stylesheet" href="<s:url value='css/common.css'/>"/>
    <link rel="stylesheet" href="<s:url value='css/personal.css'/>"/>
    <link rel="stylesheet"
          href="<s:url value='js/layer/skin/default/layer.css'/>"/>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="left_ct">
        <div class="panel panel-default" style="background-color:rgba(0,0,0,0);">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <strong>我的信息</strong>
                </h3>
            </div>
            <ul class="list-group">
                <li onclick="showCont('cont_pwd')" class="list-group-item liActive">修改密码</li>
                <li onclick="showCont('cont_headImg')" class="list-group-item">修改头像
                </li>
            </ul>
        </div>

    </div>
    <div class="right_ct">
        <div id="cont_pwd" class="showcont">
            <form id="frmChangePwd" role="form" action="">
                <table class="table" style="background-color: transparent">
                    <tr>
                        <td style="color: lightblue">原密码</td>
                        <td width="300"><label for="oldPassword"></label><input name="password" id="oldPassword"
                                                                                style="background-color: transparent"
                                                                                type="password" class="form-control"
                                                                                placeholder="请输入原来的密码"
                                                                                required="required"/></td>
                        <td id="password_Tips1"></td>
                    </tr>

                    <tr>
                        <td style="color: lightblue">请输入新密码</td>
                        <td><label for="newPassword"></label><input name="newPassword" id="newPassword"
                                                                    style="background-color: transparent"
                                                                    maxlength="16" type="password" class="form-control"
                                                                    placeholder="建议6-16位的数字、字母、符号的组合密码"
                                                                    required="required"/></td>
                        <td id="password_Tips2" class="default"><span>弱</span><span>中</span><span>强</span>请牢记新密码</td>
                    </tr>
                    <tr>
                        <td style="color: lightblue">确认密码</td>
                        <td><label for="newPasswordAgain"></label><input name="newPasswordAgain" id="newPasswordAgain"
                                                                         style="background-color: transparent"
                                                                         maxlength="16" type="password"
                                                                         class="form-control"
                                                                         placeholder="再次输入密码" required="required"/></td>
                        <td id="password_Tips3">再次输入新密码</td>
                    </tr>
                </table>

                <label class="pull-right"><input class="btn btn-primary"
                                                 type="submit" value="保存更改"/></label>
            </form>
        </div>
        <div id="cont_headImg" class="showcont" style="display: none;">
            <form id="frmChangeImg" action="">
                <h4>当前我的头像</h4>
                <p>如果您还没有设置自己的头像，系统会显示为默认头像，您需要自己上传一张新照片来作为自己的个人头像</p>
                <div id="Imgdiv">
                    <img id="Img"
                         src="${pageContext.request.contextPath}/user!getHeadImg.action?headImg=${user.headImg}"
                         width="200px"
                         height="200px" alt=""/>
                    <button type="button" onclick="uploadHeadImg()"
                            class="btn btn-default" style="margin-left: 40px;">
                        <i class="glyphicon glyphicon-cloud-upload"></i> 选择新头像
                    </button>
                    <input type="file" name="uploadFile" onchange="change_headImg()"
                           accept="image/*" style="display: none;" required="required">
                </div>

                <p>
                    <label class="pull-right" style="margin-top: 30px;"><input
                            class="btn btn-primary" type="submit" value="保存更改"/></label>
                </p>
            </form>
        </div>
    </div>
</div>
<script src="layui/layui.js">
    layui.use(['element', 'layer'], function () {
        var element = layui.element;
        var layer = layui.layer;
        //监听折叠
        element.on('collapse(test)', function (data) {
            layer.msg('展开状态：' + data.show);
        });
    });
</script>
</body>
<script src="<s:url value='js/jquery-1.11.2.min.js'/>" type="javascript"></script>
<script src="<s:url value='js/bootstrap/js/bootstrap.min.js'/>" type="javascript"></script>
<script src="<s:url value='js/layer/layer.js'/>" type="javascript"></script>
<script src="<s:url value='js/personal.js'/>" type="javascript"></script>
</html>