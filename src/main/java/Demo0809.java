import com.oracle.jrockit.jfr.Producer;
import com.sun.deploy.pings.Pings;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author javie
 * @date 2019/8/9 11:30
 */
public class Demo0809 {

    public static void main(String[] args) throws Exception  {

        /*ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine js = scriptEngineManager.getEngineByName("JavaScript");
        Object o = js.eval("function cal(){ return 2*3*4/6}; cal();");
        System.out.println(o);*/
        // jvblog.nat100.top

        Object a = "111";
        new Demo0809().hello(a);
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("111" );
        list.add("111" );
        list.add("222" );
        list.add("333" );
        list.add("333" );
        HashSet<String> set = new HashSet<String>(list);
        System.out.println(set);
    }

    public void hello(int a){
        System.out.println("int");
    }
    public void hello(Integer a){
        System.out.println("Integer");
    }
    public void hello(Object a){
        System.out.println("Object");
    }
    /*public void hello(char a){
        System.out.println("char");
    }*/
    public void hello(String a){
        System.out.println("String");
    }


}
