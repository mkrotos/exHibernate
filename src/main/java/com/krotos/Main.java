package com.krotos;

import com.krotos.database.dao.MemberDao;
import com.krotos.database.dao.RunDao;
import com.krotos.database.entity.Member;
import com.krotos.database.entity.Run;
import com.krotos.database.providers.DaoProvider;
import com.krotos.database.utils.HibernateUtils;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        RunDao runDao = DaoProvider.getInstance().getRunDao();

        Run run = new Run();
        run.setName("third");
        run.setPlace("ads");
        run.setStartDate(LocalDate.now());
        run.setStartTime(LocalTime.now());
        runDao.save(run);

        Optional<Run> byId = runDao.findById(2);
        System.out.println("Find by id " + byId);

        if (byId.isPresent()) {
            byId.get().setName("updated");
            runDao.update(byId.get());
            System.out.println("Updated " + byId.get());
        }

        Run updateRun = new Run();
        updateRun.setId(1);
        updateRun.setName("updateRun");
        runDao.update(updateRun);
        System.out.println("Updated 2: " + runDao.findById(updateRun.getId()));

        List<Run> all = runDao.getAll();
        System.out.println("-------------\n" + all);

        if (byId.isPresent()) {
            runDao.delete(byId.get());
            Optional<Run> byId2 = runDao.findById(byId.get().getId());
            System.out.println("deleted: " + byId2);
        }

        Member member=new Member();
        member.setName("memberOne");
        Run runX = runDao.findById(1).get();
        member.setRun(runX);
        MemberDao memberDao=DaoProvider.getInstance().getMemberDao();
        memberDao.saveOrUpdate(member);

        System.out.println("\nRun with member: "+runX+runX.getMembers());

        HibernateUtils.getInstance().getSessionFactory().close();
    }
}
