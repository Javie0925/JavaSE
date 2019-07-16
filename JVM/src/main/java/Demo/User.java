package Demo;

/**
 * @author javie
 * @date 2019/7/12 22:21
 */
public class User {

    private int age;
    private String gender;
    private String telephone;
    private byte[] bytes = new byte[1024*1024*10];

    public User() {
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getTelephone() {
        return telephone;
    }
}
