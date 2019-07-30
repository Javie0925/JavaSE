package unchangable_class;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author javie
 * @date 2019/7/30 19:53
 */
public class ImmutableTest {
    private final int age;
    private final String name;
    private final List<String> list;

    public ImmutableTest(int age, String name, List<String> list) {
        this.age = age;
        this.name = name;
        this.list = list;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }
}
