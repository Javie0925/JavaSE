import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author javie
 * @个人网站: http://jvblog.nat100.top
 * @date 2020/3/28 23:34
 */

public class User {

    private String name;
    private Integer age;
    private String gender;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthday=" + new SimpleDateFormat().format(birthday) +
                '}';
    }
}

