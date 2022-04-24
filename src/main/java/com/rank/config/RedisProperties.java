package com.rank.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.redis") // build.gradle의 설정 덕분에 yml에도 정상적으로 매핑 가능
@Component
public class RedisProperties {
    private String host;
    private int port;
}
