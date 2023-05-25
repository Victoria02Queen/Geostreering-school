package com.example.demoSites.controllers.test;

import com.example.demoSites.models.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActiveTestRowMapper implements RowMapper<Test> {
    @Override
    public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
        Test test = new Test();
        test.setTitle(rs.getString("title"));
        test.setId(rs.getLong("id"));
        return test;
    }
}
