package com.spring01.spring_0611.Service;


import com.spring01.spring_0611.DTO.RequestCreateMemberDTO;
import com.spring01.spring_0611.DTO.RequestUpdateMemberDTO;
import com.spring01.spring_0611.DTO.ResponseMemberDTO;
import com.spring01.spring_0611.Repository.UserRepository;
import com.spring01.spring_0611.entity.Gender;
import com.spring01.spring_0611.entity.Member;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final UserRepository userRepository;

    @Override
    public long saveMember(RequestCreateMemberDTO requestCreateMemberDTO){
        Member member = Member.builder()
                .userEmail(requestCreateMemberDTO.getUserEmail())
                .userName(requestCreateMemberDTO.getUserName())
                .userAge(requestCreateMemberDTO.getUserAge())
                .gender(requestCreateMemberDTO.getGender() == 0 ? Gender.M : Gender.F)
                .build();
        return userRepository.save(member).getIdx();
    }

    @Override
    public ResponseMemberDTO findMember(Long id){
        Member member = userRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("아이디가 존재하지 않습니다람쥐.")
        );
        return ResponseMemberDTO.builder()
                .userEmail(member.getUserEmail())
                .userName(member.getUserName())
                .userAge(member.getUserAge())
                .gender(member.getGender() == Gender.M ? 0 : 1)
                .build();
    }

    @Override
    public long modifyMember(Long id, RequestUpdateMemberDTO requestUpdateMemberDTO){
        Member member = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        member.updateProfile(requestUpdateMemberDTO);
        return userRepository.save(member).getIdx();
    }

    @Override
    public long deleteMember(Long id){
        userRepository.deleteById(id);
        return id;
    }

    @Transactional
    @Override
    public List<ResponseMemberDTO> recommendMember(Long id){
        Member member = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        List<Member> memberList = userRepository.findAllByUserAgeEqualsAndGenderNot(member.getUserAge(), member.getGender());
        List<ResponseMemberDTO> resultList = new LinkedList<ResponseMemberDTO>();
        for(Member matchMember : memberList)
        {
            resultList.add(ResponseMemberDTO.builder()
                    .userEmail(matchMember.getUserEmail())
                    .userName(matchMember.getUserName())
                    .userAge(matchMember.getUserAge())
                    .gender(matchMember.getGender() == Gender.M ? 0 : 1)
                    .build());
        }
        return resultList;
    }
}
