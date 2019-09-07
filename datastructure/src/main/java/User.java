/**
 * @author javie
 * @date 2019/8/14 13:40
 */
public class User implements IUser {

    private String name = "javie";
    private int age = 22;


    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }
}
