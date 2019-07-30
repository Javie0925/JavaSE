package guarded_suspension;

import java.util.LinkedList;

/**
 * @author javie
 * @date 2019/7/30 21:39
 */
public class RequestQuene {

    private final LinkedList<Request> quene = new LinkedList<>();

    public Request getRequest(){
        synchronized (quene){
            while (quene.size()<=0){
                try{
                    quene.wait();
                } catch (InterruptedException e) {
                    return null;
                }
            }

            return quene.removeFirst();
        }
    }

    public void putRequest(Request request){
        synchronized (quene){
            quene.addLast(request);
            quene.notifyAll();
        }
    }
}
