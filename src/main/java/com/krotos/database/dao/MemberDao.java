package com.krotos.database.dao;

import com.krotos.database.entity.Member;
import com.krotos.database.entity.Run;

import java.util.List;
import java.util.Optional;

public interface MemberDao {
    void saveOrUpdate(Member member);

    List<Member> getAll();

    Optional<Member> findById(long id);

    void delete(Member member);
}
