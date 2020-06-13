<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主页</title>
    <link rel="stylesheet"
          href="<s:url value='js/bootstrap/css/bootstrap.min.css'/>"/>
    <link rel="stylesheet" href="<s:url value='css/common.css'/>"/>
    <link rel="stylesheet"
          href="<s:url value='js/layer/skin/default/layer.css'/>"/>
    <link rel="stylesheet"
          href="<s:url value='js/datetimepicker/jquery.datetimepicker.css'/>"/>
    <link rel="stylesheet" href="<s:url value='css/main.css'/>"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<!--主内容开始-->
<div class="container clearfix main-content" style="background-color: transparent;color:lightblue">
    <!--工具栏开始-->
    <div class="toolbar" style="background-color: transparent;color:lightblue">
        <div class="btn-group">
            <button type="button"
                    style="background: none; border: 1px solid #efefef; box-shadow: none; color: #999;"
                    class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <i class="glyphicon glyphicon-sort"></i> <span id="sortList-text">创建时间</span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu"
                style="min-width: 100%; text-align: center;background-color: transparent;color:lightblue">
                <li><a href="javascript:" id="sort_1"
                       onclick="sortInbox(this.id,this.title)" title="创建时间">创建时间</a></li>
                <li><a href="javascript:" id="sort_2"
                       onclick="sortInbox(this.id,this.title)" title="截止时间">截止时间</a></li>
                <li><a href="javascript:" id="sort_3"
                       onclick="sortInbox(this.id,this.title)" title="收件数量">收件数量</a></li>
                <li><a href="javascript:" id="sort_4" style="color: #f0ad4e;"
                       onclick="sortInbox(this.id,this.title)" title="只显标星">只显标星</a></li>

                <li><a href="javascript:" id="sort_5"
                       onclick="sortInbox(this.id,this.title)" title="只显截止">只显截止</a></li>
                <li><a href="javascript:" id="sort_6" style="color: #5cb85c;"
                       onclick="sortInbox(this.id,this.title)" title="只显开启">只显开启</a></li>
                <li><a href="javascript:" id="sort_7" style="color: #d9534f;"
                       onclick="sortInbox(this.id,this.title)" title="只显关闭">只显关闭</a></li>
            </ul>

        </div>

        <div class="set-btn-right">
            <a class="btn btn-set btn-outline btn-width"
               onclick="showInboxForm()"> <i
                    class="glyphicon glyphicon-pencil"
                    style="margin-left: -15px; padding-left: 10px;"></i> 创建收件夹
            </a>
        </div>
    </div>
    <!--工具栏结束-->
    <!--文件列表开始-->
    <ul class="inboxs-group" style="background-color: transparent;color:lightblue">

    </ul>
</div>
<!--主内容结束-->
<script src="<s:url value='layui/layui.js'/>"></script>
<script type="text/javascript">
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use(['jquery'], function () {
        var $ = layui.jquery;
        $(document).ready(function () {
            $.post({
                url: getWebProjectName() + '/getAll.action',
                success: function (rows) {
                    console.log(rows);
                    showInbox(rows);
                }
            });
        });

        function showInbox(rows) {
            $(".inboxs-group").html(""); // 清空列表
            for (var i = 0; i < rows.length; i++) {
                var content = undefined;
                //是否标星
                if (rows[i].star === 0) {
                    content = '<li style="background-color: transparent;color:lightblue" class="inbox" id="' + rows[i].logo + '">'
                        + '<div class="inbox-content" style="background-color: transparent">'
                        + '<a class="upvote" href=${pageContext.request.contextPath}/inboxFile.jsp?id=' + rows[i].id + ' title="收件数量(' + rows[i] + '),点击查看详细信息">'
                        + '<span class="vote-count">' + rows[i] + '</span>'
                        + '</a>'
                        + '<div class="inbox-msg">'
                        + '<a class="inbox-msg-url title" title="预览" href="inbox.jsp?link=' + rows[i].id + '" target="_blank">'
                        + rows[i].title
                        + '</a> <span class="inbox-tagline description">'
                        + ' <span class="ctime" style="margin: 0;" title="创建时间">' + rows[i].createTime.split(" ")[0] + '</span>'
                        + '<span class="endtime" title="截止时间"> '
                        + ' <i class="glyphicon glyphicon-time"></i>'
                        + rows[i].endTime.split(" ")[0]
                        + '	</span>'
                        + '</span>'
                        + '</div>'
                        + '</div>'
                        + '<div class="inbox-actions">'
                        + '<a href="javascript:;" id="link_' + rows[i].id + '" '
                        + 'onclick="showLink(this.id)" title="获取收件夹地址">'
                        + '<i class="glyphicon glyphicon-link"></i>'
                        + '</a> <a href="javascript:;" id="time_' + rows[i].id + '"'
                        + 'onclick="showEndTime(this.id,this.title)" title="截止时间:' + rows[i].endTime.split(" ")[0] + '">'
                        + '<i class="glyphicon glyphicon-time"></i></a> ';
                } else {
                    content = '<li class="inbox" id="' + rows[i].id + '">'
                        + '<div class="inbox-content">'
                        + '<a class="upvote" href=${pageContext.request.contextPath}/inboxFile.jsp?id=' + rows[i].id + ' title="收件数量(0),点击查看详细信息">'
                        + '<span class="vote-count">' + rows[i] + '</span>'
                        + '</a>'
                        + '<div class="inbox-msg">'
                        + '<a class="inbox-msg-url title" title="预览" href=${pageContext.request.contextPath}/inbox.jsp?link=' + rows[i].id + ' target="_blank">'
                        + rows[i].title
                        + ' <i class="glyphicon glyphicon-star"'
                        + 'style="font-size: 14px; color: #f0ad4e;"></i>'
                        + '</a> <span class="inbox-tagline description">'
                        + ' <span class="ctime" style="margin: 0;" title="创建时间">' + rows[i].createTime.split(" ")[0] + '</span>'
                        + '<span class="endtime" title="截止时间"> '
                        + ' <i class="glyphicon glyphicon-time"></i>'
                        + rows[i].endTime.split(" ")[0]
                        + '	</span>'
                        + '</span>'
                        + '</div>'
                        + '</div>'
                        + '<div class="inbox-actions">'
                        + '<a href="javascript:;" id="link_' + rows[i].id + '" '
                        + 'onclick="showLink(this.id)" title="获取收件夹地址">'
                        + '<i class="glyphicon glyphicon-link"></i>'
                        + '</a> <a href="javascript:;" id="time_' + rows[i].id + '"'
                        + 'onclick="showEndTime(this.id,this.title)" title="截止时间:' + rows[i].endTime.split(" ")[0] + '">'
                        + '<i class="glyphicon glyphicon-time"></i></a> ';
                }

                //是否加密
                if (rows[i].password != null && rows[i].password != "") {
                    content += '<a href="javascript:;" id="password_' + rows[i].password + '" '
                        + 'onclick="showPwdLink(this.id)"> '
                        + '<i class="glyphicon glyphicon-lock" style="color: #5cb85c;"></i></a>';
                }

                //是否关闭
                if (rows[i].status == 0) {
                    content += '<a href="javascript:;" id="open_' + rows[i].id + '" '
                        + 'onclick="closeInbox(this.id)"> '
                        + '<i class="glyphicon glyphicon-play" style="color: #5cb85c;"></i></a>'

                        + '<a id="config_' + rows[i].id + '" href="javascript:;" onclick="showAction(this.id)">'
                        + '<i class="glyphicon glyphicon-cog"></i>'
                        + '</a>'
                        + '</div>'
                        + '</li>';
                } else {
                    content += '<a href="javascript:;"  id="close_' + rows[i].id + '" '
                        + 'onclick="openInbox(this.id)"> '
                        + '<i class="glyphicon glyphicon-pause" style="color: #d9534f;"></i></a>'
                        + '<a id="config_' + rows[i].id + '" href="javascript:;" onclick="showAction(this.id)">'
                        + '<i class="glyphicon glyphicon-cog"></i>'
                        + '</a>'
                        + '</div>'
                        + '</li>';
                }
                $(".inboxs-group").append(content);
            }
        }
    });
</script>
</body>
<script src="<s:url value='js/jquery-1.11.2.min.js'/>"></script>
<script src="<s:url value='js/bootstrap/js/bootstrap.min.js'/>"></script>
<script src="<s:url value='js/layer/layer.js'/>"></script>
<script src="<s:url value='js/main.js'/>"></script>
<script src="<s:url value='js/datetimepicker/jquery.datetimepicker.js'/>"></script>

</html>