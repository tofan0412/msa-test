package com.rank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Scheduler 통해 지속적으로 TOP10 rank를 Redis 서버에 저장해야 한다.
public class RankApplication {

	public static void main(String[] args) {
		SpringApplication.run(RankApplication.class, args);
	}

}
