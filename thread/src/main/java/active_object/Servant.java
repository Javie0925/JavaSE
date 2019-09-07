package active_object;

/**
 * @author javie
 * @date 2019/8/1 1:24
 */
class Servant implements ActiveObject {


    @Override
    public Result makeString(int count, char fillChar) {

        char[] buff = new char[count];
        for (int i=0;i<count;i++){
            buff[i] = fillChar;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new RealResult(buff);
    }

    @Override
    public void displayString(String text) {
        try {
            System.out.println("DISPLAY:"+text);
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
