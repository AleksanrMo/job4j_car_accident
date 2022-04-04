package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

@Repository
public class AccidentHibernate {

   @Autowired
    SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    @Transactional
    public Accident save(Accident accident) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(accident);
            session.getTransaction().commit();
            return accident;
        }
    }

    @Transactional
    public List<Accident> getAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident", Accident.class)
                    .list();
        }
    }

    @Transactional
    public List<AccidentType> getTypes() {
        try (Session session = sf.openSession()) {
          return   session.createQuery("from AccidentType", AccidentType.class)
                  .list();
        }
    }

    @Transactional
    public AccidentType getType(int id) {
        try (Session session = sf.openSession()) {
         return session.get(AccidentType.class, id);

        }
    }

    @Transactional
    public Rule getRule(int id) {
        try (Session session = sf.openSession()) {
            return session.get(Rule.class, id);
        }

    }

    @Transactional
    public List<Rule> getRules() {
       try (Session session = sf.openSession()) {
           return session.createQuery("from Rule", Rule.class).list();
       }
    }

    @Transactional
    public Accident findById(int id) {
        try (Session session = sf.openSession()) {
            return session.get(Accident.class, id);
        }
    }
}
