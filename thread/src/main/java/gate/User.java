package gate;

/**
 * @author javie
 * @date 2019/7/30 16:31
 */
public class User extends Thread{

    private final String myName;
    private final String myAddress;
    private final Gate gate;

    public User(String myName, String myAddress, Gate gate) {
        this.myName = myName;
        this.myAddress = myAddress;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(myName+" begin");
        while (true){
            this.gate.pass(myName, myAddress);
        }
    }
}

