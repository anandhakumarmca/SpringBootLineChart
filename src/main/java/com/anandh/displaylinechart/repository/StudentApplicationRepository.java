package com.anandh.displaylinechart.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class StudentApplicationRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final Logger log = LoggerFactory.getLogger(StudentApplicationRepository.class);

    @Autowired
    public StudentApplicationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getStudentApplicationCountByApproved() {
        String appplicationCount = "SELECT \"applicationDate\", COUNT(*) AS count FROM \"studentApplication\" WHERE \"applicationStatus\" = 'approved' GROUP BY \"applicationDate\" ORDER BY \"applicationDate\"";
        try {
            //log.info("AppplicationCount :"+ appplicationCount);
            return jdbcTemplate.queryForList(appplicationCount);
        } catch (Exception e) {
            log.error("Error : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
