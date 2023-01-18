package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService ms;
    MemoryMemberRepository mr;

    @BeforeEach
    public void beforeEah(){    //DI의존성주입.
        mr = new MemoryMemberRepository();
        ms = new MemberService(mr);
    }

    @AfterEach
    public void afterEach(){
        mr.clearStore();
    }

    @Test
    void sign() {
        Member member = new Member();
        member.setName("test1");

        int savedId = ms.sign(member);  //1

        int findById = ms.findById(member.getId()).get().getId();

        if(findById == savedId) {
            System.out.println("같다.");
        }
        Assertions.assertEquals(findById, savedId);
    }

    @Test
    public void validDuplicatedMember(){
        Member m3 = new Member();
        m3.setName("duplicated");

        Member m4 = new Member();
        m4.setName("duplicated kk");


        ms.sign(m3);
        ms.sign(m4);
    }

    @Test
    void findAllMember() {
        Member m1 = new Member();
        m1.setName("test1");
        ms.sign(m1);

        Member m2 = new Member();
        m2.setName("test3");
        ms.sign(m2);

        List<Member> allMemberList = ms.findAllMember();
        for(Member m : allMemberList){
            System.out.println(m.getName());
        }
    }

    @Test
    void findById() {

    }
}