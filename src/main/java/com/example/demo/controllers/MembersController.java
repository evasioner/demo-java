package com.example.demo.controllers;

import com.example.demo.domain.Members;
import com.example.demo.response.Response;
import com.example.demo.services.MembersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RequestMapping("/members")
@Api(tags = {"1. Members"})
@RestController
public class MembersController extends BaseController {
    final private MembersService memberService;

    MembersController(MembersService memberService) {
        this.memberService = memberService;
    }

    @ApiOperation(value = "회원 조회", notes = "모든 회원을 조회")
    @GetMapping("")
    public Response<List<Members>> getMembers() {
        return response(memberService.getMembers());
    }

    @ApiOperation(value = "회원 가입", notes = "회원 가입")
    @PostMapping("")
    public Response<Members> joinMembers(Members members) {
        return response(memberService.joinMembers(members));
    }

    @ApiOperation(value = "회원 조회", notes = "특정 회원을 조회.")
    @GetMapping("/{memberNo}")
    public Response<Members> getMemberByMemberNo(@PathVariable BigInteger memberNo) {
        return response(memberService.getMemberByMemberNo(memberNo));
    }
}
