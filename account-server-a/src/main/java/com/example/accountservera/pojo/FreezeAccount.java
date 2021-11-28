package com.example.accountservera.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author junyangwei
 * @date 2021-11-28
 */
@Data
public class FreezeAccount {
    private Integer id;
    private Long transactionId;
    private Integer userId;
    private Double freezeDollar;
    private Double freezeYuan;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
