package com.alo.SATScoreTracker.repository;

import com.alo.SATScoreTracker.entity.SatResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatResultRepository extends JpaRepository<SatResult, Long> {

    SatResult findByName(String name);
}

