package com.example.accountservera.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author junyangwei
 * @date 2021-11-28
 */
@Data
public class AccountYuan {
    private Integer id;
    private Integer userId;
    private Double yuan;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
