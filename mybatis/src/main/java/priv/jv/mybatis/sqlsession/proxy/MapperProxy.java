package priv.jv.mybatis.sqlsession.proxy;

        import priv.jv.mybatis.cfg.Mapper;
        import priv.jv.mybatis.utils.Executor;

        import java.lang.reflect.InvocationHandler;
        import java.lang.reflect.Method;
        import java.sql.Connection;
        import java.util.List;
        import java.util.Map;

/**
 * @author javie
 * @date 2019/8/19 14:10
 */
public class MapperProxy implements InvocationHandler {

    private Map<String,Mapper> mappers;

    private Connection conn;

    public MapperProxy(Map<String,Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获取mapper对象
        String nameSpace = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String key = nameSpace+"."+methodName;
        Mapper mapper = mappers.get(key);
        if (mapper==null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        // 调用工具类执行查询
        return new Executor().selectList(mapper, conn);
    }
}
