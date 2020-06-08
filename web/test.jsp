<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form">
    <input type="text" name="name" id="username">
    <input type="text" name="psw" id="password">
    <input type="button" value="52">
</form>

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['jquery', 'form'], function () {
        var $ = layui.jquery;
        $(":button").click(function () {
            $.post({
                url: "${pageContext.request.contextPath}/test.action",
                data: $('#form').serializeArray(),
                success: function (root) {
                    alert(root.value)
                    // var d = eval("(" + result + ")");
                    console.log(root)
                    // $('#username').text("" + d.password + "");
                    // $('#password').text("" + d.name + "");
                }
            });
        });
    });
</script>
</body>
</html>
