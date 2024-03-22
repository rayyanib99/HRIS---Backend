package com.rayyan.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rayyan.Model.ATS;

@Repository
public interface ATSRepository extends JpaRepository<ATS, Integer> 
{
	 @Query("SELECT p FROM ATS p WHERE " +
	          "p.id LIKE CONCAT('%', :query, '%')" +
	          "Or p.position LIKE CONCAT('%', :query, '%')" +
	          "Or p.date LIKE CONCAT('%', :query, '%')" +
	          "Or p.age LIKE CONCAT('%', :query, '%')" +
	          "Or p.gender LIKE CONCAT('%', :query, '%')" +
	          "Or p.legal LIKE CONCAT('%', :query, '%')" +
	          "Or p.highestEducation LIKE CONCAT('%', :query, '%')" +
	          "Or p.relExp LIKE CONCAT('%', :query, '%')" +
	          "Or p.appStatus LIKE CONCAT('%', :query, '%')" +
	          "Or p.fullName LIKE CONCAT('%', :query, '%')")
	 List<ATS> searchTraining(String query);
}


