package com.example.accountservera.service;

import com.example.demo.api.TestService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 测试接口实现
 *  - 注意：为了确保 Dubbo 能够正常扫描并注册接口接口实现，需要添加注解 @DubboService()
 *
 * @author junyangwei
 * @date 2021-11-27
 */
@DubboService()
public class TestServiceImpl implements TestService {
    @Override
    public String sayHi(String name) {
        return "hi, " + name;
    }
}
