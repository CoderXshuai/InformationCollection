<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>收件夹</title>
    <link rel="stylesheet" type="text/css" href="js/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="js/layer/skin/default/layer.css"/>
    <link href="layui/css/layui.css" media="all" rel="stylesheet"/>
    <link rel="icon"
          href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAACMUlEQVQ4T2NkoDJgRDbPxMTEi4OVIYKdlUGXkD0fvv6/wMjIeOTMmTNzkdWiGGhnZfI634tdRF6EiZB5DGfv/WWYve/nnTNnzqpiNdDExMRBQ4px/eIcbgGCpkEVmFR+ZvgnxD2F8duv/eeOnlgHEoa7ENnA47f+4DVTUYyZQUKAkQFk4I9ISwb27Rdvntt7WAOngfWrfjAcv/2HwViJGcPgR2/+MYRZsjH4m7CCDfzSF8PAU7SE4ezZs2DHYXXh8/f/GP5jcaMgNyMDJxsi2Ik2MHH6N4bLj/4yqEtBIufms38MrMwMDFE2bAy5Huxwq4g2kJRIIejleHt2gRO3IZFiosTM4GHAitN8olx4/ek/gapADgZONgaGns0/GfbW8lBm4J0X/wQmJnAxMDMxMBQu+s5wqIFCAwu8OARm7f0JdlWaMzvWpANzMl4vGxkZJciLMk22VmflefruH1iPtBATg4MWC4OkICODlCBmdsRroLGx8X8GGcH/LJ+/MzKxQjT/+/2PgU2Ei4GP4TfDlhTMoCRoICgJcE7bzfDLSRusm23fVYbvWa7gnHCmnRfDRKIM5K5bw/A9zx2smXPSToavTSHkGejuYPL/zWdsGQ7iMHQXgnJS2or/DB8THRk45x68cW7fIU2UvAwKw3J/DrDmH/8YGViYGRj42f4zsDAzMlQt/47hXWZmxn9/2Nk+MX77yf9XVmThhQ07E9ELh3n///9XxJGKX589ezaMmCwJALLsFCQwiQP3AAAAAElFTkSuQmCC"
          sizes="32x32">
    <style>
        html, body {
            background: #00BBD3 !important;
        }

        .jumbotron {
            background: none;
        }
    </style>
</head>
<body>
<div class="index-content clearfix text-center">
    <img src="img/step_0.png"/>
    <div class="jumbotron" style="padding-bottom: 0; padding-top: 30px;">
        <div class="container">
            <div class="title2">快速创建收件夹</div>
            <div class="title3">用于向多人收取文件</div>
            <div class="start">
                <a class="btn btn-white btn-lg" id="showLogin">登录</a>
                <a class="btn btn-white btn-lg" id="showRegister">注册</a>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['jquery'], function () {
        var $ = layui.jquery;

        $("#showLogin").click(function () {
            $.ajax({
                url: getWebProjectName() + '/login.jsp',
                type: 'get',
                dataType: 'html',
                success: function (data) {
                    layer.open({
                        content: data,
                        type: 1,
                        area: ['415px', '300px'], //宽
                        zIndex: 1000,
                        title: '登录',
                        success: function (layer) {
                            var btn = layer.find('.layui-layer-title');
                            btn.css('text-align', 'center');
                        }
                    });
                }
            });
        })
        $("#showRegister").click(function () {
            $.ajax({
                url: getWebProjectName() + '/register.jsp',
                type: 'get',
                dataType: 'html',
                success: function (data) {
                    layer.open({
                        content: data,
                        type: 1,
                        area: ['515px', '330px'], //宽
                        zIndex: 1000,
                        title: '注册',
                        success: function (layer) {
                            var btn = layer.find('.layui-layer-title');
                            btn.css('text-align', 'center');
                        }
                    });
                }
            });
        })

        function getWebProjectName() {
            var webProjectName = undefined;
            //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
            var pathName = window.document.location.pathname;
            //获取带"/"的项目名，如：/uimcardprj
            webProjectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

            return webProjectName;
        }
    });
</script>
</body>
<script src="js/jquery-1.11.2.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/layer/layer.js" type="text/javascript" charset="utf-8"></script>
</html>
