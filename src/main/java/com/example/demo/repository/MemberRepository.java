package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member sign(Member member);

    Optional <Member> findById (int id);

    Optional<Member> findByName(String name);

    List<Member> findAllMember();

    Member login(String name, String password);
}
