package com.rayyan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rayyan.Model.Payroll;

@Repository
public interface PayrollRepository extends JpaRepository <Payroll, Integer> {}

