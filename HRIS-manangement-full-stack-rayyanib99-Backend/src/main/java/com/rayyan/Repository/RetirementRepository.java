package com.rayyan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rayyan.Model.Retirement;

@Repository
public interface RetirementRepository extends JpaRepository<Retirement, Integer> {}
