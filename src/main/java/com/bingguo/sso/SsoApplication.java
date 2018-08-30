package com.bingguo.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//接口扫描，如果此处不加@MapperScan注解必须在接口类上添加@Mapper注解表明这是一个接口扫描器
@MapperScan("com.bingguo.sso.mapper")
public class SsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoApplication.class, args);
	}
}
