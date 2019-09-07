package thread_local;

/**
 * @author javie
 * @date 2019/7/31 0:06
 */
public class ThreadLocalTest2 {

    private ThreadLocal threadLocal = new ThreadLocal();

    public void hello(){
        System.out.println(threadLocal.get());
    }
}
