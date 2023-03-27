package com.example.demoSites.repo;

import com.example.demoSites.models.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
