package com.rank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@AllArgsConstructor
@Getter
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Long vodId;

    private List<Long> userList;
}
