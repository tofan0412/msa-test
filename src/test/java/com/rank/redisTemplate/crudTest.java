package com.rank.redisTemplate;

import com.rank.entity.Rank;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class crudTest {

    // 테스트 객체
    @RedisHash("rank")
    public class Rank implements Serializable {
        @Id
        private Integer id;
        private Map<Long, List<Long>> vodMap;

        public Rank(Integer id, Map<Long, List<Long>> vodMap) {
            this.id = id;
            this.vodMap = vodMap;
        }

        public Integer getId() {
            return id;
        }

        public Map<Long, List<Long>> getVodMap() {
            return vodMap;
        }
    }


    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    @DisplayName("Rank 객체를 Redis DB에 삽입한다.")
    void insertRankData() {
        // Error

        // given
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        Integer testKey = 1;
        Long testVodId = 1L;
        Map<Long, List<Long>> testVodMap = new HashMap<>();
        List<Long> testUserList = new ArrayList<>(Arrays.asList(1L, 3L, 6L, 5L));

        testVodMap.put(testVodId, testUserList);

        List<Long> userList = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        Rank rank = new Rank(testKey, testVodMap);

        hashOperations.putAll(String.valueOf(rank.getId()), rank.getVodMap());

    }
}
