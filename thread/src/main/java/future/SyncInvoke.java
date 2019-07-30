package future;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author javie
 * @date 2019/7/30 20:21
 */
public class SyncInvoke {
    public static void main(String[] args) throws InterruptedException {
       /* String s = get();
        System.out.println(s);*/

        FutureService futureService = new FutureService();
        Future<String> future = futureService.submit(() -> {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        },System.out::println);
        System.out.println("==========================");
        System.out.println("..........");
        Thread.sleep(1000);
        System.out.println("==========================");
        String s = future.get();
        System.out.println(s);
    }

    public static String get(){

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "FINISH";
    }
}
