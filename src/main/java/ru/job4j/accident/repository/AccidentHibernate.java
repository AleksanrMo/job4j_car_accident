package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import java.util.List;
import java.util.function.Function;

public class AccidentHibernate {

    SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public void save(Accident accident) {
        tx(s -> {
             if (accident.getId() == 0) {
                 s.save(accident);
             } else {
                 s.update(accident);
             }
             return 1;
         });

    }

    public List<Accident> getAll() {
      return tx(s -> s.createQuery("from Accident ").list());
    }


    public List<AccidentType> getTypes() {
        return tx(s -> s.createQuery("from AccidentType").list());
    }


    public AccidentType getType(int id) {
       return tx(s -> s.get(AccidentType.class, id));
    }


    public Rule getRule(int id) {
       return tx(s -> s.get(Rule.class, id));

    }


    public List<Rule> getRules() {
       return tx(s -> s.createQuery("from Rule").list());
    }


    public Accident findById(int id) {
       return tx(s -> s.get(Accident.class, id));
    }

    public <T> T tx(Function<Session, T> function) {
        Session session = sf.openSession();
        Transaction  tx = session.beginTransaction();
      T t = null;
        try {
          t =  function.apply(session);
            tx.commit();
            return t;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return t;
    }
}
