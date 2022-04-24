package com.rank.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RankServiceImplTest {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void testString() {
        final String key = "testString";

        final ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();

        stringStringValueOperations.set(key, "1");
        final String result = stringStringValueOperations.get(key);

        Assertions.assertThat(result).isEqualTo("1");
    }


}
