package com.oauth.securitytest.service;

import com.oauth.securitytest.dto.RequestCreateMemberDTO;
import com.oauth.securitytest.dto.RequestUpdateMemberDTO;
import com.oauth.securitytest.dto.ResponseMemberDTO;

import java.util.List;

public interface MemberService {
    long saveMember(RequestCreateMemberDTO requestCreateMemberDTO);
//    ResponseMemberDTO findMember(Long id);
//    long modifyMember(Long id, RequestUpdateMemberDTO requestUpdateMemberDTO);
//    long deleteMember(Long id);
//    List<ResponseMemberDTO> recommendMember(Long id);
}
