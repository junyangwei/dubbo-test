package com.example.accountserverb;

import com.example.demo.api.TestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AccountServerBApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServerBApplication.class, args);
	}

	/**
	 * 声明要调用的接口
	 */
	@DubboReference(version = "1.0.0")
    private TestService testService;

	/**
	 * 测试调用方法
	 */
	@GetMapping("/test")
	public void test() {
		System.out.println("测试使用 Dubbo 进行 RPC 调用服务 A 的 TestService 接口实现...");
		String message = testService.sayHi("dubbo");
		System.out.println("调用响应结果: " + message);
	}

}
