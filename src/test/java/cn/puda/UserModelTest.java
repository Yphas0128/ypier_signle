package cn.puda;

import cn.puda.config.IgnoreUrlsConfig;
import cn.puda.entity.User;
import cn.puda.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

/**
 * @title: UserModelTest
 * @Author Ypier
 * @Date: 2021/4/6 8:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserModelTest {
    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;
    @Autowired
    private UserService userService;

    @Test
    public void  test(){
        User user = userService.selectUserByUsername("user1");
        System.out.println(user);
    }

    @Test
    public  void  test1(){
        List<String> urls = ignoreUrlsConfig.getUrls();
        System.out.println(urls);
    }
}
