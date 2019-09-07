package domain;

/**
 * @author javie
 * @date 2019/8/19 17:06
 */
public class User {

    private int userno;

    private String name;

    private int age;

    @Override
    public String toString() {
        return "User{" +
                "userno=" + userno +
                ", username='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserno() {
        return userno;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
