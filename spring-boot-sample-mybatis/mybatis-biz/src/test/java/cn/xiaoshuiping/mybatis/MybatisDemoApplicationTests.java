package cn.xiaoshuiping.mybatis;

import cn.xiaoshuiping.mybatis.dao.UserMapper;
import cn.xiaoshuiping.mybatis.dto.User;
import cn.xiaoshuiping.mybatis.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        List<User> users = userService.findAllUser(1,2);
        System.out.println(users.get(0).getUserName());
    }
}
