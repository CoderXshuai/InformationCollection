<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form">
    <input type="text" name="name" id="username" value="">
    <input type="text" name="psw" id="password" value="">
    <input type="button" value="52">
</form>

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['jquery'], function () {
        var $ = layui.jquery;
        $(":button").click(function () {
            $.post({
                url: "${pageContext.request.contextPath}/test.action",
                data: $('#form').serializeArray(),
                success: function (root) {
                    // alert(root.val)
                    // var d = eval("(" + root + ")");
                    // console.log(root)
                    console.log(root.name)
                    console.log(root.password)
                    $(":button").text
                    $("#username").val("" + root.password + "");
                    $("#password").val("" + root.name + "");
                }
            });
        });
    });
</script>
</body>
</html>
