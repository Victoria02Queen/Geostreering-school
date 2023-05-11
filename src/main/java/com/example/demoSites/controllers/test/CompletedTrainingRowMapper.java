package com.example.demoSites.controllers.test;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompletedTrainingRowMapper implements RowMapper<CompletedTrainingDto> {
    @Override
    public CompletedTrainingDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        CompletedTrainingDto completedTrainingDto = new CompletedTrainingDto();
        completedTrainingDto.setUserName(rs.getString("userName"));
        completedTrainingDto.setTrainingName(rs.getString("trainingName"));
        completedTrainingDto.setCountCorrectAnswer(rs.getInt("countCorrectAnswer"));
        completedTrainingDto.setCompletedDate(rs.getTimestamp("completedDate"));
        return completedTrainingDto;
    }
}
