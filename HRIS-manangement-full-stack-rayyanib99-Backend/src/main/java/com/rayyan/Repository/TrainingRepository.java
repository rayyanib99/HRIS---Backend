package com.rayyan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rayyan.Model.Training;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer>
{
    @Query("SELECT p FROM Training p WHERE " +
            "p.id LIKE CONCAT('%',:query, '%')" +
            "Or p.trainingName LIKE CONCAT('%', :query, '%')" +
            "Or p.completed LIKE CONCAT('%', :query, '%')")
    List<Training> searchTraining(String query);
}

