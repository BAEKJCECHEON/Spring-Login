package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller //bean 등록이 된다.
public class MemberController {

    private final MemberService ms;

    //하나의 컨테이너만 등록하고 연결해서 사용 (DI)
    @Autowired
    public MemberController(MemberService ms) {
        this.ms = ms;
    }

    Member member1 = new Member();

    @GetMapping("members/new")
    public String sign(){
        return "/members/new";
    }

    @PostMapping("/members/new")
    public String signPost(Member member){
        member1.setName(member.getName());
        member1.setPassword(member.getPassword());

        ms.sign(member);
        System.out.println("name : " + member.getName());
        System.out.println("id : " + member.getId());
        System.out.println("password : " + member.getPassword());
        return "redirect:/";
    }

    @GetMapping("/members")
    public String members(Model model){
        List<Member> allMembers = ms.findAllMember();
        model.addAttribute("allMembers", allMembers);
        return "members/members";
    }

    @GetMapping("/members/login")
    public String login(){
        return "members/login";
    }

    @PostMapping("/members/login")
    public String loginPost(Member member, HttpSession session){
        member1.setName(member.getName());
        member1.setPassword(member.getPassword());


        int code = ms.login(member);
        System.out.println("code : " + code);
        if(code ==200) {    //로그인 성공
            System.out.println("session success");
            session.setAttribute("name", member.getName());
        }
        return "redirect:/";
    }

    @GetMapping("/members/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
