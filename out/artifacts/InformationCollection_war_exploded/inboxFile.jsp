<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8"/>
    <title>快速创建收件夹</title>
    <link rel="stylesheet" type="text/css" href="js/bootstrap/css/bootstrap.min.css"/>

    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/header.css"/>
    <link rel="stylesheet" type="text/css" href="js/layer/skin/default/layer.css"/>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>

<body>
<!--导航栏开始-->
<jsp:include page="header.jsp"/>
<!--导航栏结束-->
<!--主内容开始-->
<div class="inboxFile-content container clearfix" style="background-color: transparent">
    <ol class="breadcrumb" style="background-color: transparent">
        <li><a href="#">首页</a></li>
        <li id="title"></li>
        <li class="active">收件记录</li>
    </ol>
    <button type="button" class="btn btn-default" style="margin-bottom: 20px;background-color:transparent; "
            onclick="delInboxFile()">
        <i class="glyphicon glyphicon-trash" style="color:lightblue"></i>
        <span id="sortList-text" style="background-color: transparent;color:lightblue">删除文件</span>

    </button>
    <div class="panel panel-default" style="border-bottom:0;box-shadow:none;background-color: transparent">
        <table class="table table-hover" style="background-color: transparent;color:lightblue">
            <thead>
            <tr style="background-color: transparent;">
                <th align="center" style="background-color: transparent">
                    <input id="check_all" type="checkbox" autocomplete="off">
                </th>
                <th width="20px" style="background-color: transparent;color:lightblue"></th>
                <th id="fileName" style="background-color: transparent">文件名称</th>
                <th style="background-color: transparent">文件大小</th>
                <th style="background-color: transparent">上传时间</th>
                <th style="background-color: transparent">操作</th>
            </tr>
            </thead>
            <tbody id="docs">

            </tbody>
        </table>
    </div>
</div>
<!--主内容结束-->
<script type="text/javascript">
</script>
<script src="layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['jquery'], function () {
        var $ = layui.jquery
        var linkId = '${param.id}'
        console.log(linkId)
        $.post({
            url: getWebProjectName() + '/getDocs.action',
            data: 'linkId=' + linkId,
            success: function (result, status) {
                console.log(result)
                console.log(status)
                for (var i = 0; i < result.length; i++) {
                    $('#docs').append("<tr style=\"background-color: transparent\">\n" +
                        "                <th align=\"center\"><input id=\"check_all\" type=\"checkbox\" autocomplete=\"off\"></th>\n" +
                        "                <th width=\"20px\"></th>\n" +
                        "                <th id=\"fileName\">" + result[i].name + "</th>\n" +
                        "                <th>" + result[i].size + "</th>\n" +
                        "                <th>" + result[i].createTime + "</th>\n" +
                        "                <th>" + '<a href="javascript:" id="close_  rows[i].id  "\n' +
                        '           onclick="openInbox(this.id)">\n' +
                        '            <i class="glyphicon glyphicon-pause" style="color: #d9534f;"></i>\n' +
                        '        </a>\n' +
                        '        <a href="javascript:" id="config_  rows[i].id  " onclick="showAction(this.id)">\n' +
                        '            <i class="glyphicon glyphicon-cog"></i>\n' +
                        '        </a>' + "</th>\n" +
                        "            </tr>")
                }
            }
        });
    });

    function showAction(id) {
        $.ajax({
            url: 'actions.html',
            type: 'get',
            dataType: 'html',
            success: function (data) {
                layer.open({
                    content: [data, '#' + id],
                    type: 4,
                    area: ['200px', '225px'],
                    shade: 0,
                    zIndex: 1000,
                    tips: [4, "#fff"],
                    success: function (layero, index) {
                        $(".config-menu").attr("id", id);
                    }
                });
            }
        });
    }

    function getWebProjectName() {
        var webProjectName = undefined;
        // 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
        var pathName = window.document.location.pathname;
        // 获取带"/"的项目名，如：/uimcardprj
        webProjectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

        return webProjectName;
    }
</script>
</body>
<script src="js/jquery-1.11.2.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/layer/layer.js" type="text/javascript" charset="utf-8"></script>
<script src="js/inboxFile.js" type="text/javascript" charset="utf-8"></script>

</html>