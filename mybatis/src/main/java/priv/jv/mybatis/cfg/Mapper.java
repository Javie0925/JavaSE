package priv.jv.mybatis.cfg;

/**
 * @author javie
 * @date 2019/8/19 12:57
 * 用于封装执行的SQL语句和结果类的权限定类名
 */
public class Mapper {

    private String queryString;
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
