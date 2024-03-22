package com.rayyan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rayyan.Model.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {}

