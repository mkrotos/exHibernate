package com.krotos.database.dao;

import com.krotos.database.entity.Run;
import com.krotos.database.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class RunDaoImpl implements RunDao {
    private Session session;

    public RunDaoImpl(){
        session=HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
    }
    @Override
    public void save(Run run) {
        session.save(run);
    }

    @Override
    public List<Run> getAll() {
        return session.createQuery("from Run").list();
    }

    @Override
    public Optional<Run> findById(long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void update(Run run) {

    }
}
