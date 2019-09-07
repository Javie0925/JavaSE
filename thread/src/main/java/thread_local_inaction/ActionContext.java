package thread_local_inaction;

/**
 * @author javie
 * @date 2019/7/31 15:52
 */
public class ActionContext {

    public static final ThreadLocal<Context> threadLocal = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new Context();
        }
    };

    private ActionContext(){

    }

    private static class ContxtHolder{
        private final static ActionContext context = new ActionContext();
    }

    public static ActionContext getActionContext(){
        return ContxtHolder.context;
    }

    public Context getContext(){
        return threadLocal.get();
    }
}
