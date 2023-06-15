package com.example.demoSites.repo;

import com.example.demoSites.controllers.test.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class TrainingDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public void deleteTraining(long id){
        String sql = "DELETE FROM training WHERE id = :id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        jdbcTemplate.update(sql,map);
    }
}
