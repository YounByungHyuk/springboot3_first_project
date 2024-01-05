package org.example.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public void test(){
        //jpa를 통한 예제
        // 생성
        memberRepository.save(new Member(1L,"A"));

        // 조회
        Optional<Member> member = memberRepository.findById(1L);
        // findid 는 아이디를 통한 조회
        List<Member> allMembers = memberRepository.findAll();
        //삭제

        memberRepository.deleteById(1L);
        // 아이디를 통한 삭제
    }
}
