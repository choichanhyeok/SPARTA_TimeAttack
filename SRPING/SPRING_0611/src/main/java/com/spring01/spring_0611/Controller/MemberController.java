package com.spring01.spring_0611.Controller;


import com.spring01.spring_0611.DTO.RequestCreateMemberDTO;
import com.spring01.spring_0611.DTO.RequestUpdateMemberDTO;
import com.spring01.spring_0611.DTO.ResponseMemberDTO;
import com.spring01.spring_0611.Service.MemberService;
import com.spring01.spring_0611.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/create")
    public ApiResponse createMember(@RequestBody RequestCreateMemberDTO requestCoupleDTO){
        long retId = memberService.saveMember(requestCoupleDTO);
        return ApiResponse.success("result", retId);
    }

    @GetMapping("/read/{id}")
    public ApiResponse readMember(@PathVariable Long id){
         ResponseMemberDTO responseMemberDTO = memberService.findMember(id);
        return ApiResponse.success("result", responseMemberDTO);
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateMember(@PathVariable Long id, @RequestBody RequestUpdateMemberDTO requestUpdateMemberDTO){
        long retId = memberService.modifyMember(id, requestUpdateMemberDTO);
        return ApiResponse.success("result", retId);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteMember(@PathVariable Long id){
        long retId = memberService.deleteMember(id);
        return ApiResponse.success("result", retId);
    }

    @GetMapping("/recommend/{id}")
    public ApiResponse recommendMember(@PathVariable Long id){
        List<ResponseMemberDTO> responseMemberDTOList = memberService.recommendMember(id);
        return ApiResponse.success("result", responseMemberDTOList);
    }
}
