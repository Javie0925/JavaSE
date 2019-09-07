package priv.jv.mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * @author javie
 * @date 2019/8/19 12:52
 * 自定义mybatis的自定义类
 */
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String,Mapper> mappers = new HashMap<>();

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);  //  因为可能有很多mapper，为了防止覆盖，应使用追加的方式
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
