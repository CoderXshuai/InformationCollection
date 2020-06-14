//初始化大部分 文件后缀名
var audio = ['mp3', 'wav', 'ra', 'wma', 'mid'];
var video = ['avi', 'mpg', 'mov', 'swf'];
var reduce = ['rar', 'zip', 'gz', 'z', 'arj'];
var text = ['txt', 'doc', 'html', 'pdf'];
var picture = ['bmp', 'gif', 'jpg', 'pic', 'png', 'tif', 'jpeg'];

$(function () {
    load();
})

function getInboxId() {
    var urlParam = window.location.search;
    inbox_id = urlParam.split("=")[1];
    return inbox_id;
}


/**
 * 加载标题
 * @param title
 */
function loadTitle(title) {
    $("#title").html(title);
}

function loadDoc(Docs) {
    $("#docs").html(""); //清空文件
    for (var i = 0; i < Docs.length; i++) {
        var content = undefined;
        content += '<tr>' +
            '<td width="45"><input class="file_checkbox" id="' + Docs[i].id + '" type="checkbox"  autocomplete="off"></td>';
        if ($.inArray(getFileExt(Docs[i].name), audio) != -1) {
            content += '<td><span class="glyphicon glyphicon-music"></span></td>';
        } else if ($.inArray(getFileExt(Docs[i].name), video) != -1) {
            content += '<td><span class="glyphicon glyphicon-film"></span></td>';
        } else if ($.inArray(getFileExt(Docs[i].name), reduce) != -1) {
            content += '<td><span class="glyphicon glyphicon-tasks"></span></td>';
        } else if ($.inArray(getFileExt(Docs[i].name), text) != -1) {
            content += '<td><span class="glyphicon glyphicon-file"></span></td>';
        } else if ($.inArray(getFileExt(Docs[i].name), picture) != -1) {
            content += '<td><span class="glyphicon glyphicon-picture"></span></td>';
        }
        content += '<td align="left" style="width: 400px;">' + Docs[i].name + '</td>' +
            '<td>' + Docs[i].size + '</td>' +
            '<td>' + Docs[i].createTime + '</td>' +
            '<td><a href="/inbox/download.action?fileUrl=' + Docs[i].url + '&fileName=' + Docs[i].name + '"><span class="glyphicon glyphicon-download-alt"></span>下载</a></td>' +
            '</tr>';
        $("#docs").append(content);
    }
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

function getFileExt(fileName) {
    var index1 = fileName.lastIndexOf(".");
    var index2 = fileName.length;
    var ext = fileName.substring(index1 + 1, index2);
    return ext;
}


//返回当前选中的文件数
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


