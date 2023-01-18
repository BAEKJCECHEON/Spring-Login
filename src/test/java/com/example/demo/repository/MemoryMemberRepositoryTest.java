package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

/*
public class MemoryMemberRepositoryTest {
    MemoryMemberRepository mmr = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        mmr.clearStore();
    }

    @Test
    public void sign(){
        Member member = new Member();
        member.setName("test_name");

        mmr.sign(member);
        Member findById = mmr.findById(member.getId()).get();

        System.out.println(findById == member);
        Assertions.assertEquals(member, findById);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("test_name");
        mmr.sign(member1);

        Member member2 = new Member();
        member2.setName("db_test");
        mmr.sign(member2);

        Member result1 = mmr.findByName(member1.getName()).get();
        Member result2 = mmr.findByName(member2.getName()).get();

        System.out.println(result1.getName());
        System.out.println(result2.getName());

        Assertions.assertEquals(result1, member1);
    }

    @Test
    public void fi1ndAllMember(){
        Member member1 = new Member();
        member1.setName("test_name");
        mmr.sign(member1);

        Member member2 = new Member();
        member2.setName("db_test");
        mmr.sign(member2);

        List<Member> allMember = mmr.findAllMember();

        //test1
        for(Member m : allMember) {
            System.out.println(m.getName());
        }

        //test2
        Assertions.assertEquals(allMember.size(), 2);
    }
}
*/