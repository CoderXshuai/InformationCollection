<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet"
          href="<s:url value='js/bootstrap/css/bootstrap.min.css'/>"/>
    <link rel="stylesheet" href="<s:url value='css/common.css'/>"/>
    <link rel="stylesheet"
          href="<s:url value='js/layer/skin/default/layer.css'/>"/>
    <link rel="stylesheet"
          href="<s:url value='js/datetimepicker/jquery.datetimepicker.css'/>"/>
    <link rel="stylesheet" href="<s:url value='css/main.css'/>"/>
</head>
<body onload="load()">
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
    });
</script>
</body>
<script src="<s:url value='js/jquery-1.11.2.min.js'/>"></script>
<script src="<s:url value='js/bootstrap/js/bootstrap.min.js'/>"></script>
<script src="<s:url value='js/layer/layer.js'/>"></script>
<script src="<s:url value='js/main.js'/>"></script>
<script src="<s:url value='js/datetimepicker/jquery.datetimepicker.js'/>"></script>

</html>