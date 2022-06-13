package com.spring01.spring_0611.Service;

import com.spring01.spring_0611.DTO.RequestCreateMemberDTO;
import com.spring01.spring_0611.DTO.RequestUpdateMemberDTO;
import com.spring01.spring_0611.DTO.ResponseMemberDTO;

import java.util.List;

public interface MemberService {
    long saveMember(RequestCreateMemberDTO requestCreateMemberDTO);
    ResponseMemberDTO findMember(Long id);
    long modifyMember(Long id, RequestUpdateMemberDTO requestUpdateMemberDTO);
    long deleteMember(Long id);
    List<ResponseMemberDTO> recommendMember(Long id);
}
