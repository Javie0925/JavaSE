package unchangable_class;

import java.util.stream.IntStream;

/**
 * @author javie
 * @date 2019/7/30 19:43
 */
public class ImmutableClient {

    public static void main(String[] args) {
        // share data
        Person person = new Person("Alex", "Gangsu");

        IntStream.rangeClosed(1, 5).forEach(i->{
            new UserPersonThread(person).start();
        });

    }
}
