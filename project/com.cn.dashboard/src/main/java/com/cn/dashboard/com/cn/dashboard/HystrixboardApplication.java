package com.cn.dashboard.com.cn.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixboardApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HystrixboardApplication.class, args);
	}

}
