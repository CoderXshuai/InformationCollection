package util;

import java.io.File;

public class Static {
    //session名称
    public static final String ONLINE_USER = "user";

    //inbox状态符
    public static final int INBOX_NOSTAR = 0;
    public static final int INBOX_STAR = 1;
    public static final int INBOX_ON = 0;
    public static final int INBOX_OFF = 1;

    //图片资源路径
    public static final String SRC_PATH = Config.getValues("uploadDirectory");
    public static final String INBOX_PATH = SRC_PATH + File.separator + "inbox";
    public static final String IMG_PATH = SRC_PATH + File.separator + "img";
    public static final String USER_HEADIMG = IMG_PATH + File.separator + "usersHeadImg";
    public static final String INBOX_LOGO = IMG_PATH + File.separator + "inboxLogo";

    public static String getHtmlMail(String email, String code) {
        String htmlMail = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" +
                "    <title></title>\n" +
                "    <meta charset=\"utf-8\"/>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"qmbox qm_con_body_content qqmail_webmail_only\" id=\"mailContentContainer\" style=\"\">\n" +
                "    <style type=\"text/css\">\n" +
                "        .qmbox body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            background: #fff;\n" +
                "            font-family: \"Verdana, Arial, Helvetica, sans-serif\";\n" +
                "            font-size: 14px;\n" +
                "            line-height: 24px;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox div, .qmbox p, .qmbox span, .qmbox img {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox img {\n" +
                "            border: none;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .contaner {\n" +
                "            margin: 0 auto;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .title {\n" +
                "            margin: 0 auto;\n" +
                "            background: url() #CCC repeat-x;\n" +
                "            height: 30px;\n" +
                "            text-align: center;\n" +
                "            font-weight: bold;\n" +
                "            padding-top: 12px;\n" +
                "            font-size: 16px;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .content {\n" +
                "            margin: 4px;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .biaoti {\n" +
                "            padding: 6px;\n" +
                "            color: #000;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .xtop, .qmbox .xbottom {\n" +
                "            display: block;\n" +
                "            font-size: 1px;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .xb1, .qmbox .xb2, .qmbox .xb3, .qmbox .xb4 {\n" +
                "            display: block;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .xb1, .qmbox .xb2, .qmbox .xb3 {\n" +
                "            height: 1px;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .xb2, .qmbox .xb3, .qmbox .xb4 {\n" +
                "            border-left: 1px solid #BCBCBC;\n" +
                "            border-right: 1px solid #BCBCBC;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .xb1 {\n" +
                "            margin: 0 5px;\n" +
                "            background: #BCBCBC;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .xb2 {\n" +
                "            margin: 0 3px;\n" +
                "            border-width: 0 2px;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .xb3 {\n" +
                "            margin: 0 2px;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .xb4 {\n" +
                "            height: 2px;\n" +
                "            margin: 0 1px;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .xboxcontent {\n" +
                "            display: block;\n" +
                "            border: 0 solid #BCBCBC;\n" +
                "            border-width: 0 1px;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .line {\n" +
                "            margin-top: 6px;\n" +
                "            border-top: 1px dashed #B9B9B9;\n" +
                "            padding: 4px;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .neirong {\n" +
                "            padding: 6px;\n" +
                "            color: #666666;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .foot {\n" +
                "            padding: 6px;\n" +
                "            color: #777;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .font_darkblue {\n" +
                "            color: #006699;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .font_lightblue {\n" +
                "            color: #008BD1;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "\n" +
                "        .qmbox .font_gray {\n" +
                "            color: #888;\n" +
                "            font-size: 12px;\n" +
                "        }\n" +
                "    </style>\n" +
                "    <div class=\"contaner\">\n" +
                "        <div class=\"title\">邮箱验证码</div>\n" +
                "        <div class=\"content\">\n" +
                "            <p class=\"biaoti\"><b>亲爱的用户，你好！</b></p>\n" +
                "            <b class=\"xtop\"><b class=\"xb1\"></b><b class=\"xb2\"></b><b class=\"xb3\"></b><b class=\"xb4\"></b></b>\n" +
                "            <div class=\"xboxcontent\">\n" +
                "                <div class=\"neirong\">\n" +
                "                    <p><b>邮箱名：</b><span id=\"userName\" class=\"font_darkblue\">" + email +
                "</span></p>\n" +
                "                    <p><b>验证码：</b><span class=\"font_lightblue\"><span id=\"yzm\" data=" + code + "\n" +
                "                                                                             onclick=\"return false;\" t=\"7\"\n" +
                "                                                                             style=\"border-bottom: 1px dashed rgb(204, 204, 204); z-index: 1; position: static;\">" + code + "</span></span><br><span\n" +
                "                            class=\"font_gray\">(请输入该验证码完成，验证码30分钟内有效！)</span></p>\n" +
                "                    <div class=\"line\">如果你未申请服务，请忽略该邮件。</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <b class=\"xbottom\"><b class=\"xb4\"></b><b class=\"xb3\"></b><b class=\"xb2\"></b><b class=\"xb1\"></b></b>\n" +
                "           </div>\n" +
                "    </div>\n" +
                "    <style type=\"text/css\">\n" +
                "        .qmbox style, .qmbox script, .qmbox head, .qmbox link, .qmbox meta {\n" +
                "            display: none !important;\n" +
                "        }\n" +
                "    </style>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        return htmlMail;
    }
}
