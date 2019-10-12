package com.example.demo.controllers;

import com.example.demo.domain.Member;
import com.example.demo.response.Response;
import com.example.demo.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RequestMapping("/member")
@RestController
public class MemberController extends BaseController {
    @Autowired
    private MemberService memberService;

    @GetMapping("")
    public Response<List<Member>> getMembers() {
        return this.response(this.memberService.getMembers());
    }

    @GetMapping("/{memberNo}")
    public Response<Member> getMemberByMemberNo(@PathVariable BigInteger memberNo) {
        return this.response(memberService.getMemberByMemberNo(memberNo));
    }
}
