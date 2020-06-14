package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author CoderXshuai
 */
public class Config {
    private static final String fileNamePath = "./conf/config.properties";

    public static String getValues(String key) {
        Properties props = new Properties();
        InputStream in = null;
        try {
            /*in = new FileInputStream(fileNamePath);*/
            in = Config.class.getClassLoader().getResourceAsStream(fileNamePath);
            props.load(in);
            return props.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

}
