package com.eureka.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eureka.domain.Inform;
import com.eureka.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;

@SpringBootTest
public class InformServiceTest {
    @Autowired
    private InformService informService;

    /**
     * service.list()查询所有数据，以泛型的对象数组返回；
     */
    @Test
    void testGetAll(){
        System.out.println(informService.list());
    }
    @Test
    void testGetById(){
        System.out.println(informService.getById(2));
    }
    @Test
    void testSave(){
        Inform inform = new Inform();
        //inform.setWantedId(2);
        inform.setWantedHead("kk's coding");
        inform.setLeader("kk");
        inform.setPersonCur(1);
        inform.setPersonAll(5);
        inform.setBrief("you are all crash!");
        System.out.println(informService.save(inform));
    }
    @Test
    void testUpdate(){
        Inform inform = new Inform();
        inform.setId(2);
        inform.setWantedHead("kkk's coding");
        inform.setLeader("kkk");
        inform.setPersonCur(10);
        inform.setPersonAll(50);
        inform.setBrief("you are the best!");
        System.out.println(informService.updateById(inform));
    }
    @Test
    void testDelete(){
        informService.removeById(2);
    }

    @Test
    void testGetPage(){
        IPage<Inform> page = informService.getPage(1, 5);
        System.out.println(page.getRecords());
    }
}
