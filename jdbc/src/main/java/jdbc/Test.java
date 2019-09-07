package jdbc;

import bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * @author javie
 * @date 2019/8/16 10:11
 */
public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        DataSource ds = new ComboPooledDataSource();

        Connection conn = ds.getConnection();
        conn.close();
        StringBuilder sb = new StringBuilder();
        sb.deleteCharAt(1);
        sb.charAt(1);
        Class<?> aClass = Class.forName("");
        Annotation[] annotations = aClass.getAnnotations();
        Class<?> aClass1 = Test.class.getClassLoader().loadClass("");
        new LinkedHashMap();

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor p : propertyDescriptors) {
                Method readMethod = p.getReadMethod();
                readMethod.getName();
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

    }
}
