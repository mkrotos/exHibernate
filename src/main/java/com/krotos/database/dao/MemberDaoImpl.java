package com.krotos.database.dao;

import com.krotos.database.entity.Member;
import com.krotos.database.entity.Run;
import com.krotos.database.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class MemberDaoImpl implements MemberDao {

    private Session getCurrentSession() {
        return HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
    }

    @Override
    public void saveOrUpdate(Member member) {
        Session session = getCurrentSession();
        session.beginTransaction();
        session.save(member);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Member> getAll() {
        Session session = getCurrentSession();
        session.beginTransaction();
        List<Member> memberList = session.createQuery("from Member").list();
        session.getTransaction().commit();
        session.close();
        return memberList;
    }

    @Override
    public Optional<Member> findById(long id) {
        Session session = getCurrentSession();
        session.beginTransaction();
        Optional<Member> member = Optional.ofNullable(session.get(Member.class, id));
        session.getTransaction().commit();
        session.close();
        return member;
    }

    @Override
    public void delete(Member member) {
        Session session = getCurrentSession();
        session.beginTransaction();
        session.delete(member);
        session.getTransaction().commit();
        session.close();
    }
}
