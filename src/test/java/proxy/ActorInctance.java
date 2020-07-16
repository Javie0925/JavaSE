package proxy;

/**
 * @author javie
 * @个人网站: http://jvblog.nat100.top
 * @date 2020/3/24 22:15
 */
public class ActorInctance implements Actor {
    @Override
    public void lowPlay(int money) {
        System.out.println("low play");
    }

    @Override
    public void midPlay(int money) {
        System.out.println("mid play");
    }

    @Override
    public void highPlay(int money) {
        System.out.println("high play");
    }
}
