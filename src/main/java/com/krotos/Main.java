package com.krotos;

import com.krotos.database.utils.HibernateUtils;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory=HibernateUtils.getInstance().getSessionFactory();
        sessionFactory.close();
    }
}
