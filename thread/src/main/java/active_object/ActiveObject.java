package active_object;

/**
 * 接受异步消息的主动方法
 * @author javie
 * @date 2019/8/1 1:16
 */
public interface ActiveObject {


    Result  makeString(int count,char fillChar);

    void displayString(String text);

}
