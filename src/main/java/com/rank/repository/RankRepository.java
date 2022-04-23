package com.rank.repository;

import com.rank.entity.Rank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RankRepository extends CrudRepository<Rank, String> {

    @Override
    List<Rank> findAll();

}
