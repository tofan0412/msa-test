package com.rank.service;

import com.rank.entity.Rank;
import com.rank.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class RankServiceImpl implements RankService {

    private final RankRepository rankRepository;

    @Override
    public List<Rank> findAllRank() {
        return rankRepository.findAll();
    }
}
