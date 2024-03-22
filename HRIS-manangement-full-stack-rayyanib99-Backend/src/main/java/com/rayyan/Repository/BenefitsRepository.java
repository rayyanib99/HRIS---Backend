package com.rayyan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rayyan.Model.Benefits;

@Repository
public interface BenefitsRepository extends JpaRepository<Benefits, Integer> {}

