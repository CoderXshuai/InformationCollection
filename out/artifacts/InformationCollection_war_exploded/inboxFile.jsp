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
    <link rel="icon"
          href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAACMUlEQVQ4T2NkoDJgRDbPxMTEi4OVIYKdlUGXkD0fvv6/wMjIeOTMmTNzkdWiGGhnZfI634tdRF6EiZB5DGfv/WWYve/nnTNnzqpiNdDExMRBQ4px/eIcbgGCpkEVmFR+ZvgnxD2F8duv/eeOnlgHEoa7ENnA47f+4DVTUYyZQUKAkQFk4I9ISwb27Rdvntt7WAOngfWrfjAcv/2HwViJGcPgR2/+MYRZsjH4m7CCDfzSF8PAU7SE4ezZs2DHYXXh8/f/GP5jcaMgNyMDJxsi2Ik2MHH6N4bLj/4yqEtBIufms38MrMwMDFE2bAy5Huxwq4g2kJRIIejleHt2gRO3IZFiosTM4GHAitN8olx4/ek/gapADgZONgaGns0/GfbW8lBm4J0X/wQmJnAxMDMxMBQu+s5wqIFCAwu8OARm7f0JdlWaMzvWpANzMl4vGxkZJciLMk22VmflefruH1iPtBATg4MWC4OkICODlCBmdsRroLGx8X8GGcH/LJ+/MzKxQjT/+/2PgU2Ei4GP4TfDlhTMoCRoICgJcE7bzfDLSRusm23fVYbvWa7gnHCmnRfDRKIM5K5bw/A9zx2smXPSToavTSHkGejuYPL/zWdsGQ7iMHQXgnJS2or/DB8THRk45x68cW7fIU2UvAwKw3J/DrDmH/8YGViYGRj42f4zsDAzMlQt/47hXWZmxn9/2Nk+MX77yf9XVmThhQ07E9ELh3n///9XxJGKX589ezaMmCwJALLsFCQwiQP3AAAAAElFTkSuQmCC"
          sizes="32x32">
</head>

<body>
<!--导航栏开始-->
<jsp:include page="header.jsp"/>
<!--导航栏结束-->
<!--主内容开始-->
<div class="inboxFile-content container clearfix" style="background-color: transparent">
    <ol class="breadcrumb" style="background-color: transparent">
        <li><a href="main.jsp" style="color: lightblue">首页</a></li>
        <li id="title" style="color: lightblue">${param.title}</li>
        <li class="active" style="color: lightblue">收件记录</li>
    </ol>
    <button type="button" class="btn btn-default" style="margin-bottom: 20px;background-color:transparent; "
            id="del">
        <i class="glyphicon glyphicon-trash" style="color:lightblue"></i>
        <span style="background-color: transparent;color:lightblue">删除文件</span>
    </button>
    <button type="button" class="btn btn-default" style="margin-bottom: 20px;background-color:transparent; "
            id="download">
        <i class="glyphicon glyphicon-download-alt" style="color:lightblue"></i>
        <span style="background-color: transparent;color:lightblue">下载文件</span>
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
                        "                <th align=\"center\"><input id=\"check\" type=\"checkbox\" autocomplete=\"off\" class='file_checkbox'></th>\n" +
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
        loadAction();
        $("#del").click(function () {
            console.log('http://localhost:8080/' + getWebProjectName() / 'delDoc.action')
            $.ajax({
                url: '${pageContext.request.contextPath}/delDoc.action',
                data: 'inboxId=' + linkId,
                success: function (data) {
                    showSuccessMsg(data.msg)
                    window.location.reload()
                }
            });
        });
        $("#download").click(function () {
            window.location.href = "download.action?inboxId=" + linkId;
        });

        function loadAction() {
            $("#check_all").bind('click', function () {
                var flag = $(this).is(":checked");
                var inputs = $("input[class='file_checkbox']");
                console.log(inputs.length)
                if (flag) {
                    //全选
                    for (var i = 0; i < inputs.length; i++) {
                        inputs[i].checked = true;
                    }
                    $("#fileName").html("已选中" + inputs.length + "个文件");
                    //修改样式
                    $("table tbody tr").addClass("checkActive");
                } else {
                    //全不选
                    for (var i = 0; i < inputs.length; i++) {
                        inputs[i].checked = false;
                    }
                    $("#fileName").html("文件名称");
                    $("table tbody tr").removeClass("checkActive");
                }
            })
            $("#check").bind('click', function () {
                console.log(5)
                var flag = $(this).is(":checked");
                var inputs = $("input[class='file_checkbox']");
                var num = checkNum();
                console.log(num)

                if (flag) {
                    //选中该tr
                    $(this).parent("td").parent("tr").addClass("checkActive");
                    if (num == inputs.length) {
                        $("input[id='check_all']")[0].checked = true;
                        $("#fileName").html("已选中" + num + "个文件");
                    } else {
                        $("#fileName").html("已选中" + num + "个文件");
                    }
                } else {
                    $(this).parent("td").parent("tr").removeClass("checkActive");
                    if (num == 0) {
                        $("input[id='check_all']")[0].checked = false;
                        $("#fileName").html("文件名称");
                    } else {
                        $("input[id='check_all']")[0].checked = false;
                        $("#fileName").html("已选中" + num + "个文件");
                    }
                }
            })
        }

    });


    function checkNum() {
        var inputs = $("input[class='file_checkbox']");
        var j = 0;
        for (var i = 0; i < inputs.length; i++) {
            if (inputs[i].checked) {
                j++;
            }
        }
        return j;
    }

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

    function showSuccessMsg(msg) {
        layer.msg(msg, {
            time: 3000, // 2s后自动关闭
            icon: 1
        });
    }

    function showErrorMsg(msg) {
        layer.msg(msg, {
            time: 3000, // 2s后自动关闭
            icon: 2
        });
    }
</script>
</body>
<script src="js/jquery-1.11.2.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/layer/layer.js" type="text/javascript" charset="utf-8"></script>
<script src="js/inboxFile.js" type="text/javascript" charset="utf-8"></script>

</html>