package com.findhouse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//单元测试走测试环境配置
//@ActiveProfiles("test")
//还有问题没有解决，一定使用测试数据库就报错
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

}
