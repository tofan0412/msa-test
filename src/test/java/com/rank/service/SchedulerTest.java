package com.rank.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@SpringBootTest
@EnableScheduling
@Component // scheduler를 사용하기 위해선 사용할 클래스를 bean으로 등록해야 한다.
// 따라서 @Service, @Controller, @Repository 등의 어노테이션이 이미 추가되어 있는 경우에는 별도로 추가할 필요가 없다.
public class SchedulerTest {

    @Test
    @Scheduled(fixedDelay = 2000)
    public void fixedDelayTest() throws InterruptedException { // Thread 클래스의 sleep 클래스 메서드를 사용하므로, 예외에 대한 처리
        System.out.println("fixedDelayTest 출력입니다..");
        Thread.sleep(5000);

        // fixedDelay의 경우 메서드의 종료 시간을 기준으로 시간 간격을 갖는다.
    }

    @Test
    @Scheduled(fixedRate = 2000)
    public void fixedRateTest() throws InterruptedException {
        System.out.println("fixedRateTest 출력합니다..");
        Thread.sleep(3000);

        // fixedRate의 경우 fixedDelay와 다르게 메서드의 시작 시간을 기준으로 시간 간격을 계산한다.
    }

    @Test
    @Scheduled(fixedDelay = 1000, initialDelay = 3000)
    public void fixedDelayLoofTest() throws InterruptedException {
        System.out.println("fixedDelay 루프 테스트 합니다..");

        // initialDelay의 경우 메서드가 실행되기 전 최초의 시간딜레이를 의미한다.
    }
}
