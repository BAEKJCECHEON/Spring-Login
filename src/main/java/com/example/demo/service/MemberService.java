package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository mmr;

    @Autowired
    public MemberService(MemberRepository mmr) {    //DI(의존성주입)
        this.mmr = mmr;
    }

    /**
     * 회원가입
     *
     * @param member
     * @return
     */
    public int sign(Member member) {
        //중복회원 검사
        validDuplicatedMember(member);

        //회원가입
        mmr.sign(member);
        return member.getId();
    }

    private void validDuplicatedMember(Member member) {
        Optional<Member> result = mmr.findByName(member.getName());
        if (result.isPresent()) {
            throw new IllegalStateException("중복!!");
        }
    }

    public List<Member> findAllMember() {
        return mmr.findAllMember();
    }

    public Optional<Member> findById(int memberId) {
        return mmr.findById(memberId);
    }

    /**
     * 로그인
     */
    public int login(Member member) {
        int loginCode = 0;
        String result = mmr.login(member.getName(), member.getPassword()).getPassword();
        String result1 = mmr.login(member.getName(), member.getPassword()).getName();
        if (result1.equals(member.getName())) {
            if (Objects.equals(result, member.getPassword())) {
                System.out.println("success");
                loginCode = 200;
            }else {
                System.out.println("fail");
            }
        }else {
            System.out.println("fail");
        }
        return loginCode;
    }
}
