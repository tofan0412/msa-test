package com.rank.service;

import com.rank.entity.Rank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RankService {

    List<Rank> findAllRank();

}
