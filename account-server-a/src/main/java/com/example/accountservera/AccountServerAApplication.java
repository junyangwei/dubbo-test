package com.example.accountservera;

import com.example.demo.api.AccountService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.example.accountservera.mapper")
@RestController
public class AccountServerAApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServerAApplication.class, args);
	}

	@Resource(name = "accountServiceA")
	private AccountService accountService;

	@GetMapping("/test_account_a")
	public String test() {
		accountService.accountExchange();
		return "success!!!";
	}

}
