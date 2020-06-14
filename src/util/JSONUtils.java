package util;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成json文件工具类 by xwd
 */
public class JSONUtils {

    //封装创建json文件的方法
    public static File createJSONFile(Object obj, String fileName, String inboxId) {
        boolean flag = true;
        File file = null;

        try {//获取文件的绝对路径 根路径
            String filePath = Static.INBOX_JSON + File.separator + inboxId;
            // String fileName = "app";
            String jsonString = JSON.toJSONString(obj);
            //拼接文件完整路径生成json格式文件
            String fullPath = filePath + File.separator + fileName + ".json";
            // 保证创建一个新文件
            file = new File(fullPath);
            if (!file.getParentFile().exists()) {
                // 如果父目录不存在，创建父目录
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                // 如果已存在,删除旧文件
                file.delete();
            }
            //创建新文件
            file.createNewFile();

            if (jsonString.indexOf("'") != -1) {
//将单引号转义一下，因为JSON串中的字符串类型可以单引号引起来的
                jsonString = jsonString.replaceAll("'", "\\'");
            }
            if (jsonString.indexOf("\"") != -1) {
//将双引号转义一下，因为JSON串中的字符串类型可以单引号引起来的
                jsonString = jsonString.replaceAll("\"", "\\\"");
            }

            if (jsonString.indexOf("\r\n") != -1) {
//将回车换行转换一下，因为JSON串中字符串不能出现显式的回车换行
                jsonString = jsonString.replaceAll("\r\n", "\\u000d\\u000a");
            }
            if (jsonString.indexOf("\n") != -1) {
//将换行转换一下，因为JSON串中字符串不能出现显式的换行
                jsonString = jsonString.replaceAll("\n", "\\u000a");
            }
// 将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            System.out.println("json文件内容：" + jsonString);
            write.write(jsonString);
            System.out.println("文件创建成功！");
            write.flush();
            write.close();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return file;
    }

    public static Object convertToJSON(String json, String fileName) {
        List<Object> objects = JSON.parseArray(json);
        Map<String, String> stringMap = new HashMap<>(10);
        List<String> hobbies = new ArrayList<>();
        int provinceId = 0;
        for (Object o : objects) {
            Map<String, String> map = (Map<String, String>) o;
            String key = "";
            String value = "";
            switch (map.get("name")) {
                case "province":
                    provinceId = Integer.parseInt(map.get("value"));
                    value = Static.getProvCity(provinceId, 0)[0];
                    key = "province";
                    break;
                case "city":
                    value = Static.getProvCity(provinceId, Integer.parseInt(map.get("value")))[1];
                    key = "city";
                    break;
                case "hobby":
                    hobbies.add(map.get("value"));
                    break;
                case "":
                    break;
                default:
                    value = map.get("value");
                    key = map.get("name");
                    break;
            }
            if ((!key.equals("")) || (!value.equals(""))) {
                stringMap.put(key, value);
            }
        }
        stringMap.put("hobby", hobbies.toString());

        return stringMap;
    }
}
