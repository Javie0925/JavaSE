package thread_local_inaction;

/**
 * @author javie
 * @date 2019/7/31 15:15
 */
public class ExecutionTask implements Runnable{

    private QueryFromDBAction queryFromDBAction = new QueryFromDBAction();

    private QueryFromHttpAction httpAction = new QueryFromHttpAction();

    @Override
    public void run() {

        Context context = ActionContext.getActionContext().getContext();
        queryFromDBAction.execute();
        System.out.println("name:"+context.getName());
        httpAction.execute();
        System.out.println("cardId:"+context.getCardId());
    }
}
