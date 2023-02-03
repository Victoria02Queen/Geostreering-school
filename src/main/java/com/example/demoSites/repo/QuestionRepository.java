package com.example.demoSites.repo;

import com.example.demoSites.models.Question;
import com.example.demoSites.models.Test;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}
