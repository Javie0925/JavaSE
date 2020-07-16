package com.jv;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author javie
 * @个人网站: http://jvblog.nat100.top
 * @date 2020/3/28 23:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= TestApplication.class)
public class Test {

    @Autowired
    private RestTemplate restTemplate;

    @org.junit.Test
    public void test1(){
        String forObject = restTemplate.getForObject("http://www.baidu.com", String.class);
        System.out.println(forObject);
    }
}
