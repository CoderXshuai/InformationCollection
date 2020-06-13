var $ = layui.lay.modules.jquery
$(function () {
    // 加载页面时 同时加载该用户的inbox信息
    loadInbox(1);
})

function loadInbox(sortId) {
    $.ajax({
        url: getWebProjectName() + '/getAll.action',
        data: sortId,
        type: 'POST',
        success: function (data) {
            console.log(data, status)
            if (status === 'success') {
                console.info(data.rows)
                showInbox(data.rows);
            } else {
                showErrorMsg(data.msg);
            }
        }
    })
}


function sortInbox(id, title) {
    $("#sortList-text").html(title);
    // 获取id传给后台 按照要求进行排序操作
    loadInbox(id.split("_")[1]);
}

function setEndTime(id) {
    var endTime = $("#datetimepicker").val();
    var data = {
        id: id,
        endTime: endTime
    }
    $.ajax({
        url: getWebProjectName() + '/updateEndTime.action',
        type: 'POST',
        data: data,
        dataType: 'json',
        success: function (data) {
            if (data.status) {
                // 设置成功后
                loadInbox();
                closeLayer();
                showSuccessMsg(data.msg);
            } else {
                showErrorMsg(data.msg);
            }
        }
    })
}

function setCloseReason(id) {
    var reason = $("#close_reason").val();
    var data = {
        id: id,
        closeReason: reason
    }
    $.ajax({
        url: getWebProjectName() + '/closeInbox.action',
        type: 'POST',
        data: data,
        dataType: 'json',
        success: function (data) {
            if (data.status) {
                // 设置成功后
                loadInbox();
                closeLayer();
                showSuccessMsg(data.msg);
            } else {
                showErrorMsg(data.msg);
            }
        }
    });
}

function openInbox(id) {
    var inbox_id = id.split("_")[1];
    // 确定开启后
    $.ajax({
        url: getWebProjectName() + '/openInbox.action?id=' + inbox_id,
        type: 'POST',
        success: function (data) {
            if (data.status) {
                // 设置成功后
                loadInbox();
                closeLayer();
                showSuccessMsg(data.msg);
            } else {
                showErrorMsg(data.msg);
            }
        }
    });
}

function showLink(id) {
    // 这里的id 加上标号 link_id
    var inbox_id = id.split("_")[1];
    var url = '/inbox.html?link=' + inbox_id;
    var data = '<h3 style="color: #000 ;margin-top: 0px;font-size: 16px;line-height: 20px;padding: 2px 15px;">收件地址</h3>'
        + '<ul class="config-menu">'
        + '<li class="divider"></li>'
        + '<li>'
        + '<div class="input-group">'
        + '<input id="1234" type="text" value="'
        + url
        + '" class="form-control" readonly="readonly">'
        + '<span class="input-group-btn">'
        + '<button  onclick="copy()" class="btn btn-default" type="button">复制</button>'
        + '</span>' + '</div>' + '</li>' + '</ul>';
    layer.open({
        content: [data, '#' + id],
        type: 4,
        area: ['400px',],
        shade: 0,
        zIndex: 1000,
        tips: [4, "#fff"],
    });
}

function showPwdLink(id) {
    var password = id.split("_")[1];
    var data = '<h3 style="color: #000 ;margin-top: 0px;font-size: 16px;line-height: 20px;padding: 2px 15px;">收件密码</h3>'
        + '<ul class="config-menu">'
        + '<li class="divider"></li>'
        + '<li>'
        + '<div class="input-group">'
        + '<input id="1234" type="text" value="'
        + password
        + '" class="form-control" readonly="readonly">'
        + '<span class="input-group-btn">'
        + '<button  onclick="copy()" class="btn btn-default" type="button">复制</button>'
        + '</span>' + '</div>' + '</li>' + '</ul>';
    layer.open({
        content: [data, '#' + id],
        type: 4,
        area: ['400px',],
        shade: 0,
        zIndex: 1000,
        tips: [4, "#fff"],
    });
}


function showEndTime(id, title) {
    var inbox_id = id.split("_")[1];
    var time = title.split(":")[1];
    var data = '<h3 style="color: #000 ;margin-top: 0px;font-size: 16px;line-height: 20px;padding: 2px 15px;">设置截至时间</h3>'
        + '<ul class="config-menu">'
        + '<li class="divider"></li>'
        + '<li>'
        + '<div class="input-group">'
        + '<input  id="datetimepicker" type="text" value="'
        + time
        + '"  class="form-control">'
        + '</div>'
        + '</li>'
        + '<li>'
        + '<div class="input-group">'
        + '<button onclick="closeLayer()" class="btn btn-default" type="button" style="margin-top:10px;margin-left:90px">取消</button>'
        + '<button onclick="setEndTime(\'' + inbox_id + '\')" class="btn btn-success" type="button" style="margin-top:10px;margin-left:10px">确定</button>'
        + '</div>' + '</li>' + '</ul>';
    layer.open({
        content: [data, '#' + id],
        type: 4,
        area: ['270px',],
        shade: 0,
        zIndex: 1000,
        tips: [4, "#fff"],
    });

    $('#datetimepicker').datetimepicker({
        lang: 'ch',
        timepicker: false,
        format: 'Y-m-d',
        minDate: '-1970/01/01',
        maxDate: getdateLastMonth(),
    });
}


function showInboxForm() {
    $.ajax({
        url: 'inboxForm.html',
        type: 'get',
        dataType: 'html',
        success: function (data) {
            layer.open({
                content: data,
                type: 1,
                area: ['630px', '550px'], // 宽
                zIndex: 1000,
                title: '创建收件夹'
            });
        }
    });
}


function closeLayer() {
    layer.close(layer.index);
}

function copy() {
    // 这里的id 加上标号 input_id
    var e = document.getElementById(1234);
    e.select();
    document.execCommand("Copy");
    // 显示复制成功
    layer.close(layer.index);
    showSuccessMsg("复制成功")
}


// 显示菜单操作
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

function deleteInbox() {
    var id = $(".config-menu").attr("id");
    var inbox_id = id.split("_")[1];
    $.ajax({
        url: getWebProjectName() + '/inbox!delete.action?id=' + inbox_id,
        type: 'POST',
        success: function (data) {
            if (data.status) {
                // 设置成功后
                loadInbox();
                closeLayer();
                showSuccessMsg(data.msg);
            } else {
                showErrorMsg(data.msg);
            }
        }
    });
}

function setInboxPwd(id) {
    var password = $("#inbox_pwd").val();
    var data = {
        id: id,
        password: password
    };
    $.ajax({
        url: getWebProjectName() + '/inbox!updatePwd.action',
        type: 'POST',
        data: data,
        dataType: 'json',
        success: function (data) {
            if (data.status) {
                // 设置成功后
                loadInbox();
                layer.closeAll();
                showSuccessMsg(data.msg);
            } else {
                showErrorMsg(data.msg);
            }
        }
    })
}

/**
 * 获取下一月的当天
 */
function getdateLastMonth() {
    var now = new Date()
    y = now.getFullYear()
    m = now.getMonth() + 1 + 1
    d = now.getDate()
    m = m < 10 ? "0" + m : m
    d = d < 10 ? "0" + d : d
    return y + "/" + m + "/" + d
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
