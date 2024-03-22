package com.rayyan.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rayyan.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{
	@Query("SELECT p FROM Employee p WHERE " +
	          "p.empId LIKE CONCAT('%', :query, '%')" +
	          "Or p.firstName LIKE CONCAT('%', :query, '%')" +
	          "Or p.lastName LIKE CONCAT('%', :query, '%')" +
	          "Or p.age LIKE CONCAT('%', :query, '%')" +
	          "Or p.jobTitle LIKE CONCAT('%', :query, '%')" +
	          "Or p.city LIKE CONCAT('%', :query, '%')" +
	          "Or p.state LIKE CONCAT('%', :query, '%')" +
	          "Or p.country LIKE CONCAT('%', :query, '%')" +
	          "Or p.role LIKE CONCAT('%', :query, '%')")
	 List<Employee> searchTraining(String query);
}
