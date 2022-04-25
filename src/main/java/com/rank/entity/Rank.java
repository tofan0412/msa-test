package com.rank.entity;

import lombok.AllArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@AllArgsConstructor
public class Rank {
    @Id
    private Integer id;

    private Long vodId;

    private List<Long> userList;
}
