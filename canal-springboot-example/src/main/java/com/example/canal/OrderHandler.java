package com.example.canal;

import com.example.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

/**
 * 监听表的数据变化
 *
 * @author kermit
 * @since 2023/4/18 13:20
 */
@Slf4j
@Component
@CanalTable("t_order")
public class OrderHandler implements EntryHandler<Order> {

    @Override
    public void insert(Order order) {
        log.info("插入了数据[{}]", order);
    }

    @Override
    public void update(Order before, Order after) {
        log.info("修改了数据，before{}.after {}", before, after);
    }

    @Override
    public void delete(Order order) {
        log.info("删除了数据{}", order);
    }
}
