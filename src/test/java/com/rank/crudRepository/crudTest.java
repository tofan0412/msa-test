package com.rank.crudRepository;


import com.rank.entity.Rank;
import com.rank.repository.RankRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class crudTest {

    @Autowired
    RankRepository rankRepository;

    @AfterEach
    void afterEach() {
        // test 후 모든 데이터 삭제
        rankRepository.deleteAll();
    }

    @Test
    @DisplayName("Rank 객체를 Redis DB에 삽입한다.")
    void insertRankTest() {
        // given
        Integer testKey = 1;
        Long testVodId = 1L;
        List<Long> userList = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        Rank rank = new Rank(testKey, testVodId, userList);

        // when
        rankRepository.save(rank);
        Rank retrievedRank = rankRepository.findById(String.valueOf(testKey)).get();

        // then
        assertThat(retrievedRank.getId()).isEqualTo(testKey);
        assertThat(retrievedRank.getVodId()).isEqualTo(testVodId);
        assertThat(retrievedRank.getUserList()).isEqualTo(userList);
    }

    @Test
    @DisplayName("Rank 객체를 모두 가져온다.")
    void findAllRanksTest() {
        // given
        List<Long> userList = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        for (int i=1; i<=10; i++) {
            rankRepository.save(new Rank(i, (long) i, userList));
        }

        // when
        List<Rank> retrievedRanks = rankRepository.findAll();

        for (Rank retrievedRank : retrievedRanks) {
            System.out.println("retrievedRank = " + retrievedRank);
        }

        assertThat(rankRepository.findAll().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("Rank id로 특정 Rank 객체를 가져온다.")
    void findByIdTest() {
        // given
        List<Long> userList = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        Rank rank1 = new Rank(1, 1L, userList);
        Rank rank2 = new Rank(2, 2L, userList);

        // when
        rankRepository.save(rank1);
        rankRepository.save(rank2);

        Optional<Rank> retrievedRank = rankRepository.findById(String.valueOf(1));

        // then
        assertThat(retrievedRank.get().getVodId()).isEqualTo(1L);
        assertThat(retrievedRank.get().getVodId()).isNotEqualTo(2L);
    }
}
