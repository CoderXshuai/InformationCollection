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
    <link rel="icon" href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAACMUlEQVQ4T2NkoDJgRDbPxMTEi4OVIYKdlUGXkD0fvv6/wMjIeOTMmTNzkdWiGGhnZfI634tdRF6EiZB5DGfv/WWYve/nnTNnzqpiNdDExMRBQ4px/eIcbgGCpkEVmFR+ZvgnxD2F8duv/eeOnlgHEoa7ENnA47f+4DVTUYyZQUKAkQFk4I9ISwb27Rdvntt7WAOngfWrfjAcv/2HwViJGcPgR2/+MYRZsjH4m7CCDfzSF8PAU7SE4ezZs2DHYXXh8/f/GP5jcaMgNyMDJxsi2Ik2MHH6N4bLj/4yqEtBIufms38MrMwMDFE2bAy5Huxwq4g2kJRIIejleHt2gRO3IZFiosTM4GHAitN8olx4/ek/gapADgZONgaGns0/GfbW8lBm4J0X/wQmJnAxMDMxMBQu+s5wqIFCAwu8OARm7f0JdlWaMzvWpANzMl4vGxkZJciLMk22VmflefruH1iPtBATg4MWC4OkICODlCBmdsRroLGx8X8GGcH/LJ+/MzKxQjT/+/2PgU2Ei4GP4TfDlhTMoCRoICgJcE7bzfDLSRusm23fVYbvWa7gnHCmnRfDRKIM5K5bw/A9zx2smXPSToavTSHkGejuYPL/zWdsGQ7iMHQXgnJS2or/DB8THRk45x68cW7fIU2UvAwKw3J/DrDmH/8YGViYGRj42f4zsDAzMlQt/47hXWZmxn9/2Nk+MX77yf9XVmThhQ07E9ELh3n///9XxJGKX589ezaMmCwJALLsFCQwiQP3AAAAAElFTkSuQmCC" sizes="32x32">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="left_ct">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <strong>我的信息</strong>
                </h3>
            </div>
            <ul class="list-group">
                <li onclick="showCont('cont_pwd')" class="list-group-item liActive">修改密码</li>
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
                        <td id="password_Tips2" class="default" style="color: lightblue"><span
                                style="background-color: transparent;color: lightblue">弱</span><span
                                style="background-color: transparent;color: lightblue">中</span><span
                                style="background-color: transparent;color: lightblue">强</span>
                            请牢记新密码
                        </td>
                    </tr>
                    <tr>
                        <td style="color: lightblue">确认密码</td>
                        <td><label for="newPasswordAgain"></label><input name="newPasswordAgain" id="newPasswordAgain"
                                                                         style="background-color: transparent"
                                                                         maxlength="16" type="password"
                                                                         class="form-control"
                                                                         placeholder="再次输入密码" required="required"/></td>
                        <td id="password_Tips3" style="color: lightblue">再次输入新密码</td>
                    </tr>
                </table>

                <label class="pull-right"><input class="btn btn-primary"
                                                 type="submit" value="保存更改"/></label>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['jquery', 'layer'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        console.log(5)
        //检测密码强度
        $("#newPassword").keyup(
            function () {
                var strongRegex = new RegExp(
                    "^(?=.{14,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$",
                    "g");
                var mediumRegex = new RegExp(
                    "^(?=.{10,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$",
                    "g");
                var enoughRegex = new RegExp("(?=.{6,}).*", "g");
                if (false == enoughRegex.test($(this).val())) {
                    $("#password_Tips2")
                        .html(
                            "<span class='safe_1' style='background-color: transparent;color: lightblue'>弱</span><span class='safe_1' style='background-color: transparent;color: lightblue'>中</span><span class='safe_1' style='background-color: transparent;color: lightblue'>强");
                    $("#password_Tips2").removeClass('strong');
                    $("#password_Tips2").removeClass('medium');
                    $("#password_Tips2").removeClass('enough');
                    $("#password_Tips2").addClass('default');
                } else if (strongRegex.test($(this).val())) {
                    $("#password_Tips2").removeClass('medium');
                    $("#password_Tips2").removeClass('enough');
                    $("#password_Tips2").removeClass('strong');
                    $("#password_Tips2").addClass('strong');

                } else if (mediumRegex.test($(this).val())) {
                    $("#password_Tips2").removeClass('strong');
                    $("#password_Tips2").removeClass('enough');
                    $("#password_Tips2").removeClass('medium');
                    $("#password_Tips2").addClass('medium');

                } else {
                    $("#password_Tips2").removeClass('strong');
                    $("#password_Tips2").removeClass('medium');
                    $("#password_Tips2").removeClass('enough');
                    $("#password_Tips2").addClass('enough');
                }
                return true;
            });

        // 检查两次密码是否一致
        function checkPwd() {
            var pwd = $("input[name='newPassword']").val();
            var pwdAgain = $("input[name='newPasswordAgain']").val();
            if (pwd != pwdAgain) {
                showErrorMsg("两次输入密码不一致")
                return false;
            }
            return true;
        }

        // 异步提交表单
        $("#frmChangePwd").submit(function (e) {
            //检验
            if (checkPwd()) {
                $.ajax({
                    url: getWebProjectName() + '/changePwd.action',
                    type: 'POST',
                    datatype: 'JSON',
                    data: $('#frmChangePwd').serialize(),
                    success: function (data) {
                        if (data.status) {
                            showSuccessMsg(data.msg);
                            $("#frmChangePwd")[0].reset()
                        } else {
                            showErrorMsg(data.msg);
                        }
                    }
                })
            }
            return false;
        });

        function showSuccessMsg(msg) {
            layer.msg(msg, {
                time: 2000, // 2s后自动关闭
                icon: 1
            });
        }

        function showErrorMsg(msg) {
            layer.msg(msg, {
                time: 2000, // 2s后自动关闭
                icon: 2
            });
        }

        /**
         * 得到当前项目名称
         */
        function getWebProjectName() {
            var webProjectName = undefined;
            // 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
            var pathName = window.document.location.pathname;
            // 获取带"/"的项目名，如：/uimcardprj
            webProjectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
            return webProjectName;
        }
    });
</script>
</body>
<script src="<s:url value='js/jquery-1.11.2.min.js'/>" type="javascript"></script>
<script src="<s:url value='js/bootstrap/js/bootstrap.min.js'/>" type="javascript"></script>
<script src="<s:url value='js/layer/layer.js'/>" type="javascript"></script>
</html>