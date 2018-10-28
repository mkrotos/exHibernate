package com.krotos.database.dao;

import com.krotos.database.entity.Run;
import com.krotos.database.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class RunDaoImpl implements RunDao {

    @Override
    public void save(Run run) {
        Session session = getCurrentSession();
        session.beginTransaction();
        session.save(run);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public List<Run> getAll() {
        Session session = getCurrentSession();
        session.beginTransaction();
        List<Run> runList = session.createQuery("from Run").list();
        session.getTransaction().commit();
        session.close();
        return runList;
    }

    @Override
    public Optional<Run> findById(long id) {
        Session session = getCurrentSession();
        session.beginTransaction();
        Optional<Run> run = Optional.ofNullable(session.get(Run.class, id));
        session.getTransaction().commit();
        session.close();
        return run;
    }

    @Override
    public void delete(Run run) {
        Session session = getCurrentSession();
        session.beginTransaction();
        session.delete(run);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Run run) {
        Session session = getCurrentSession();
        session.beginTransaction();
        session.update(run);
        session.getTransaction().commit();
        session.close();

    }

    private Session getCurrentSession() {
        return HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
    }
}
