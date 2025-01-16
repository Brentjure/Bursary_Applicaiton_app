package com.brent.Bursary.repository;

import com.brent.Bursary.entity.BursaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BursaryRepo extends JpaRepository<BursaryEntity, Integer> {
}

