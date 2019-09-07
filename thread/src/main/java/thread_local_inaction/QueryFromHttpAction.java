package thread_local_inaction;

import javax.swing.*;

/**
 * @author javie
 * @date 2019/7/31 15:21
 */
public class QueryFromHttpAction {

    public void execute(){
        try {
            Thread.sleep(2_000);
            String name = ActionContext.getActionContext().getContext().getName();
            ActionContext.getActionContext().getContext().setCardId(getCardId(name));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getCardId(String name){
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+":213214536524364";
    }
}
