package priv.jv.domain;

/**
 * @author javie
 * @date 2019/8/19 14:59
 */
public class User {

    private int userno;

    private String username;

    private int age;

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userno=" + userno +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
