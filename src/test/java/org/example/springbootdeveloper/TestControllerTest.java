package org.example.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
// 테스트용 어플 컨텍스트 구성
@AutoConfigureMockMvc
// mock mvc 생성 및 자동 구성
class TestControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    public void cleanUp(){
        memberRepository.deleteAll();
        // 테스트 실행후 전부 제거
    }

    @DisplayName("getAllMembers: 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception {
        // given 준비 -> test 요청 들어왔을때 만들 개체
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));

        // when 실행- > 결과 조회하는 api 호출
        final ResultActions result = mockMvc.perform(get(url) // 1
                .accept(MediaType.APPLICATION_JSON)); // 2

        // then 검증 -> 결과 확인 ok인지 아닌지
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}