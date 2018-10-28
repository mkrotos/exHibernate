package com.krotos;

import com.krotos.database.dao.RunDao;
import com.krotos.database.dao.RunDaoImpl;
import com.krotos.database.entity.Run;
import com.krotos.database.providers.DaoProvider;
import com.krotos.database.utils.HibernateUtils;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        RunDao runDao=DaoProvider.getInstance().getRunDao();

        Run run=new Run();
        run.setName("second");
        run.setPlace("ads");
        run.setStartDate(LocalDate.now());
        runDao.saveOrUpdate(run);
        Optional<Run> byId = runDao.findById(1);
        System.out.println(byId);

        List<Run> all = runDao.getAll();
        System.out.println(all);

        HibernateUtils.getInstance().getSessionFactory().close();
    }
}
