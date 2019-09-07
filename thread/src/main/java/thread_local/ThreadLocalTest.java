package thread_local;

/**
 * @author javie
 * @date 2019/7/31 0:06
 */
public class ThreadLocalTest {

    private static ThreadLocal threadLocal = new ThreadLocal(){
        @Override
        protected String initialValue() {
            return "Javie";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        //threadLocal.set("Javie");
        Thread.sleep(2_000);
        //new ThreadLocalTest2().hello();
        System.out.println(threadLocal.get());
    }
}
