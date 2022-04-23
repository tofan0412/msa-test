package com.rank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@RedisHash("rank")
public class Rank implements Serializable {

    // id는 해당 Rank객체의 순위를 나타냄
    @Id
    private Integer id;

    private Long vodId;

    private List<Long> userList;

    public Rank(Integer id, Long vodId, List<Long> userList) {
        this.id = id;
        this.vodId = vodId;
        this.userList = userList;
    }
}
