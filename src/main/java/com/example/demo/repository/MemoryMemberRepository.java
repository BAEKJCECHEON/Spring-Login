
package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

/*
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Integer, Member> store = new HashMap<Integer, Member>();
    private static int sequence = 0;

    @Override
    public Member sign(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        store.put(member.getPassword(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAllMember() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
*/
