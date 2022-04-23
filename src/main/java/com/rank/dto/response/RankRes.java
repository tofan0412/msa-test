package com.rank.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RankRes {

    private Long voidId;

    private List<Long> userList;


}
