package active_object;

import java.lang.reflect.Method;
import java.util.LinkedList;

/**
 * @author javie
 * @date 2019/8/1 13:42
 */
public class ActivationQuene {

    private final static int MAX_METHOD_REQUEST_QUENE_SIZE = 100;

    private final LinkedList<MethodRequest> methodQuene = new LinkedList<>();

    public ActivationQuene() {

    }

    public synchronized void put(MethodRequest request){
        while (methodQuene.size()>MAX_METHOD_REQUEST_QUENE_SIZE){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        methodQuene.addLast(request);
        notifyAll();
    }

    public synchronized MethodRequest take(){
        while (methodQuene.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MethodRequest methodRequest = methodQuene.removeFirst();
        this.notifyAll();
        return methodRequest;
    }
}
