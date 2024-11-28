package com.servlet.test.repository;

import com.servlet.test.entity.Indexer;
import com.servlet.test.entity.Player;
import com.servlet.test.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class IndexerRepository {

    public List<Indexer> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Indexer", Indexer.class).list();
        }
    }
    public Indexer findById(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Indexer.class, id);
        }
    }
}
