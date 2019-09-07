package producer_and_consumer;

import java.util.LinkedList;

/**
 * @author javie
 * @date 2019/7/31 17:01
 */
public class MessageQuene {

    private final LinkedList<Message> quene;

    private final static int DEFAULT_MAX_LIMIT = 100;

    private final int limit;

    public MessageQuene(){
        this(DEFAULT_MAX_LIMIT);
    }

    public MessageQuene(int limit) {
        this.limit = limit;
        this.quene = new LinkedList<Message>();
    }

    public void put(final Message message) throws InterruptedException {
        synchronized (quene){
            while (quene.size()>limit){
                quene.wait();
            }
            quene.add(message);
            quene.notifyAll();
        }
    }

    public Message take() throws InterruptedException {
        synchronized (quene){
            while (quene.isEmpty()){
                quene.wait();
            }
            Message message = quene.removeFirst();
            quene.notifyAll();
            return message;
        }
    }

    public int getLimit() {
        return limit;
    }

    public int getMessageSize(){
        synchronized (quene){
            return quene.size();
        }
    }


}
