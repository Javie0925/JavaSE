package bean;

/**
 * @author javie
 * @date 2019/8/17 20:40
 */
public class User {

    private String userName;

    private String gender;

    private int age;

    public String getUserName() {
        return userName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
