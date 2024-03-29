package com.example.demoSites.controllers.test;

import com.example.demoSites.models.CompletedTraining;
import com.example.demoSites.models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void addActiveTraining(Long userId, Long trainingId){
        String sql = "INSERT INTO active_training (user_id, training_id) VALUES (:userId, :trainingId)";
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("trainingId", trainingId);

        jdbcTemplate.update(sql, map);
    }

    public void addCompletedTrainingFosUser(Long userId, Long trainingId, int countOfCorrectAnswer){
        String sql = "INSERT INTO completed_training (user_id, training_id, count_of_correct_answer) VALUES ( :userId, :trainingId, :countOfCorrectAnswer) ";
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("trainingId", trainingId);
        map.put("countOfCorrectAnswer", countOfCorrectAnswer);

        jdbcTemplate.update(sql, map);
    }

    public List<CompletedTrainingDto> getAllCompletedTraining(){
        String sql = "SELECT user.full_name AS userName, training.title AS trainingName, count_of_correct_answer AS countCorrectAnswer, completedDate " +
                "FROM completed_training INNER JOIN user ON completed_training.user_id = user.id " +
                "INNER JOIN training ON training.id  = completed_training.training_id ";

        return jdbcTemplate.query(sql, new CompletedTrainingRowMapper());

    }
    public List<Test> getAllActiveTestByUserId(long id){
        String sql = "SELECT test.id, test.title FROM active_training INNER JOIN test ON active_training.training_id = test.training_id WHERE active_training.user_id = :userId";
        Map<String, Object> map = new HashMap<>();
        map.put("userId", id);
        return jdbcTemplate.query(sql, map, new ActiveTestRowMapper());
    }
}
