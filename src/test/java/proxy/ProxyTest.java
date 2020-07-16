package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author javie
 * @个人网站: http://jvblog.nat100.top
 * @date 2020/3/24 22:11
 */
public class ProxyTest {

    public static void main(String[] args) {

        ActorInctance actor = new ActorInctance();

        Actor proxyActor = (Actor)Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                int money = (Integer) args[0];
                if ("lowPlay".equals(methodName)){
                    if (money>1000){
                        method.invoke(actor, money);
                    }else {
                        System.out.println("钱不够，罢演！");
                    }
                }
                if ("midPlay".equals(methodName)){
                    if (money>2000){
                        method.invoke(actor, money);
                    }else {
                        System.out.println("钱不够，罢演！");
                    }
                }
                if ("highPlay".equals(methodName)){
                    if (money>5000){
                        method.invoke(actor, money);
                    }else {
                        System.out.println("钱不够，罢演！");
                    }
                }
                return null;
            }
        });

        proxyActor.highPlay(1000);
    }
}
