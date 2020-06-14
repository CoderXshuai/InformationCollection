<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<form id="registerForm" class="form-horizontal" role="form"
      style="width: 500px; text-align: center;">
    <div class="form-group" style="margin-top: 30px;">
        <label class="col-sm-3 control-label">用户名</label>
        <div class="col-sm-8">
            <input type="text" style="height: 35px;" name="name"
                   class="form-control" placeholder="请输入用户名" required="required"
                   autocomplete="off">
        </div>
    </div>
    <div class="form-group" style="margin-top: 15px;">
        <label class="col-sm-3 control-label">邮箱号</label>
        <div class="col-sm-8">
            <input type="email" style="height: 35px;" name="email"
                   class="form-control" placeholder="请输入邮箱号" required="required"
                   autocomplete="off">
        </div>
    </div>
    <div class="form-group" style="margin-top: 15px;">
        <label class="col-sm-3 control-label">验证码</label>
        <div class="col-sm-4">
            <input type="text" style="height: 35px;" name="word"
                   class="form-control" placeholder="请输入邮箱验证码" required="required"
                   autocomplete="off">
        </div>
        <div class="col-sm-4">
            <input type="button" id="getWord" style="height: 35px;"
                   class="form-control btn btn-success" value="获取邮箱验证码">
        </div>
    </div>
    <div class="form-group" style="margin-top: 15px;">
        <label class="col-sm-3 control-label">密码</label>
        <div class="col-sm-8">
            <input type="password" style="height: 35px;" name="password"
                   class="form-control" placeholder="请设置一个密码" required="required"
                   autocomplete="off">
        </div>
    </div>
    <div class="form-group" style="margin-top: 15px;">
        <label class="col-sm-3 control-label"></label>
        <div class="col-sm-3">
            <input type="submit" style="height: 35px;"
                   class="form-control btn btn-primary" value="立即注册">
        </div>
        <div class="col-sm-3">
            <input type="button" style="height: 35px;"
                   class="form-control btn btn-default" value="返回登录">
        </div>
    </div>
</form>
<script>
    var countdown = 60; //验证倒计时
    $("#getWord").bind('click', function () {
        var email = $("input[name='email']").val();
        var data = {
            "email": email,
        }
        if (email == '') {
            showErrorMsg("请输入邮箱号码");
            return false;
        }
        settime(this);
        $.ajax({
            type: 'post',
            data: data,
            dataType: 'json',
            url: getWebProjectName() + '/sms.action',
            success: function (data) {
                if (data) {
                    showSuccessMsg("发送成功!请查收");
                }
            }
        });
    })


    $("#registerForm").submit(function (e) {
        $.ajax({
            url: '${pageContext.request.contextPath}/register.action',
            type: 'POST',
            datatype: 'JSON',
            data: $('#registerForm').serialize(),
            success: function (data) {
                if (data.status) {
                    showSuccessMsg("注册成功!将跳转至主页面");
                    layer.close(layer.index);
                    window.location.href = getWebProjectName() + '/main.jsp';
                } else {
                    showErrorMsg("注册失败,请重试!");
                }
            }
        })
        return false;
    });

    /**
     * 短信验证倒计时
     * @param {Object} obj
     */
    function settime(obj) {
        if (countdown == 0) {
            obj.removeAttribute("disabled");
            obj.value = "获取邮箱验证码";
            $("#phoneTwo_Tips").html("");
            countdown = 60;
            return;
        } else {
            obj.setAttribute("disabled", true);
            obj.value = "重新发送(" + countdown + ")";
            countdown--;
        }
        setTimeout(function () {
            settime(obj)
        }, 1000)
    }

    function showSuccessMsg(msg) {
        layer.msg(msg, {
            time: 2000, //2s后自动关闭
            icon: 1
        });
    }

    function showErrorMsg(msg) {
        layer.msg(msg, {
            time: 2000, //2s后自动关闭
            icon: 2
        });
    }

    /**
     * 得到当前项目名称
     */
    function getWebProjectName() {
        var webProjectName = undefined;
        //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
        var pathName = window.document.location.pathname;
        //获取带"/"的项目名，如：/uimcardprj
        webProjectName = pathName.substring(0,
            pathName.substr(1).indexOf('/') + 1);

        return webProjectName;
    }
</script>

