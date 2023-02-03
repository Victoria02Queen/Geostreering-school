package com.example.demoSites.repo;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository2 {

//    @Autowired
//    private  SessionFactory sessionFactory;
//    @PersistenceContext
//    EntityManagerFactory entityManagerFactory;
//
//    public Long getRightAnswerIdByQuestionId(Long id){
//        String sql = "SELECT id FROM answer INNER JOIN test_questions ON questions_id = answer.id WHERE correct = true and answer_id =" + id ;
//        Query query = sessionFactory.getCurrentSession().createQuery(sql);
//
//        Query sessionQuery = entityManagerFactory.get.createQuery(sql);
//        return (Long) sessionQuery.getResultList().get(0);
//
//    }
}
