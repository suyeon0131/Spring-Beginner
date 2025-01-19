package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 스프링 컨테이너가 관리
public class MemberController {

    private final MemberService memberService;

    @Autowired // 스프링 컨테이너에 있는 멤버 서비스를 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
