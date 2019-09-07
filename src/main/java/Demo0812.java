import domain.User;

import javax.swing.tree.TreeNode;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author javie
 * @date 2019/8/13 0:17
 */
public class Demo0812 {

    public static void main(String[] args) {
        User user = null;
        try {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("userName", "javie");
            map.put("address", "Taiwan");
            map.put("age", 21);
            map.put("gender", "male");

            BeanInfo userInfo = Introspector.getBeanInfo(User.class);

            PropertyDescriptor[] descriptors = userInfo.getPropertyDescriptors();

            user = new User();

            for (PropertyDescriptor p: descriptors) {

                Method method = p.getWriteMethod();
                String name = method.getName();
                System.out.println(name);
                for (Map.Entry<String,Object> entry:map.entrySet()){
                    if (entry.getKey().equalsIgnoreCase(name.substring(3, name.length()))){
                        method.invoke(user, entry.getValue());
                    }
                }
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
        System.out.println(user);
    }
}
