package org.example.springbootdeveloper;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자
@AllArgsConstructor
@Getter
@Entity // 엔티티로 지정

public class Member { // 테이블 접근에 사용할 객체
    @Id //아이디필드를 기본키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 기본키 자동 증가
    @Column(name="id",updatable = false)
    private long id;

    @Column(name = "name", nullable = false)
    // 네임을 not null로 설정
    private String name;
}
