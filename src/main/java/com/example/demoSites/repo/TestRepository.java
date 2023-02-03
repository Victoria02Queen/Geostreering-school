package com.example.demoSites.repo;

import com.example.demoSites.models.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long> {
//    @Query("FROM Answer INNER JOIN Question ON questions_id = answer.id WHERE correct = true and answer_id = :id")
//    Long getRightAnswerIdByQuestionId(Long id);
}
