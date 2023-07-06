package com.eureka.service;


import com.eureka.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    /**
     * service.list()查询所有数据，以泛型的对象数组返回；
     */
    @Test
    void testGetAll(){
        System.out.println(userService.list());
    }
    @Test
    void testGetById(){
        System.out.println(userService.getById(1));
    }
    @Test
    void testSave(){
        User user = new User();
        user.setUsername("kk");
        user.setPassword("123456");
        user.setEmail("123@qq.com");
        user.setPhone("18381058774");
        System.out.println(userService.save(user));
    }
    @Test
    void testUpdate(){
        User user = new User();
        user.setId(2);
        user.setUsername("kkk");
        user.setPassword("123455");
        user.setEmail("678@qq.com");
        user.setPhone("18381058775");
        System.out.println(userService.updateById(user));
    }
    @Test
    void testDelete(){
        userService.removeById(2);
    }
}
