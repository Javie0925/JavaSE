package thread_local_inaction;

/**
 * @author javie
 * @date 2019/7/31 15:16
 */
public class QueryFromDBAction {

    public void execute(){
        try {
            Thread.sleep(5_000);
            String name = Thread.currentThread().getName()+":Javie";
            ActionContext.getActionContext().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
