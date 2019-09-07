package priv.jv.mybatis.io;

import java.io.InputStream;

/**
 * @author javie
 * @date 2019/8/19 12:11
 * 使用类加载器读取配置文件
 */
public class Resources {

    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
