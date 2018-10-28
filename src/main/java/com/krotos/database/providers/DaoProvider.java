package com.krotos.database.providers;

import com.krotos.database.dao.MemberDao;
import com.krotos.database.dao.MemberDaoImpl;
import com.krotos.database.dao.RunDao;
import com.krotos.database.dao.RunDaoImpl;

public class DaoProvider {

    private static DaoProvider instance=new DaoProvider();

    private RunDao runDao;
    private MemberDao memberDao;

    private DaoProvider(){
        runDao=new RunDaoImpl();
        memberDao=new MemberDaoImpl();
    }

    public static DaoProvider getInstance() {
        return instance;
    }

    public RunDao getRunDao() {
        return runDao;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }
}
