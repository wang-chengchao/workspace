package com.example.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ExampleApplication;
import com.example.model.Order;
import com.example.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author kermit
 * @since 2023/4/18 11:56
 */
@SpringBootTest(classes = ExampleApplication.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("default")
@Slf4j
public class ExampleTest {
    @Autowired
    private IOrderService orderService;

    @Test
    public void m1() {

        IPage<Order> ret = orderService.page(new Page<>());
        log.info("ret==>{}", ret.getRecords());

    }
}
