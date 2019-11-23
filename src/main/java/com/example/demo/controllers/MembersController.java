package com.example.demo.controllers;

import com.example.demo.domain.Members;
import com.example.demo.response.Response;
import com.example.demo.services.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RequestMapping("/members")
@RestController
public class MembersController extends BaseController {
    @Autowired
    private MembersService memberService;

    @GetMapping("")
    public Response<List<Members>> getMembers() {
        return response(memberService.getMembers());
    }

    @GetMapping("/{memberNo}")
    public Response<Members> getMemberByMemberNo(@PathVariable BigInteger memberNo) {
        return response(memberService.getMemberByMemberNo(memberNo));
    }
}
