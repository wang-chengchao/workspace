package com.example.model;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

@Data
@TableName("t_order")
public class Order {

    @TableId("id")
    private Long id;

    private String name;

    private LocalDate time;

    private LocalDate payTime;
}
