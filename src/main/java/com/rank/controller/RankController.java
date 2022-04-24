package com.rank.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class RankController {

    /**
     * 서버를 구동함과 동시에, 최초의 initialDelay 5초를 가지고, 이후에응 지속적으로 fixedDelay 1초 간격으로 메서드가 실행된다.
     */
    @GetMapping("/initialDelayTest")
    @Scheduled(fixedDelay = 1000, initialDelay = 5000)
    public void InitialDelayTest() {
        log.info("Top10 Rank 수정합니다. 현재 시각 : " + System.currentTimeMillis() );
    }
}
