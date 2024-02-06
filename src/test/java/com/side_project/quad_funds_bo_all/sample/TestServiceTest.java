/**
 * packageName  : com.side_project.quad_funds_bo_all.sample
 * fileName     : TestServiceTest
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 테스트 코드 예제
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.sample;

import com.side_project.quad_funds_bo_all.entity.TestProjectMaster;
import com.side_project.quad_funds_bo_all.repository.TestRepository;
import com.side_project.quad_funds_bo_all.service.TestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

// @DataJpaTest
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
// @WebMvcTest(TestController.class)
public class TestServiceTest {

    @Autowired
    MockMvc mockMvc;

    // @Rule
    // public OutputCaptureRule outputCaptureRule = new OutputCaptureRule();

    // @MockBean                                // 저장 안 됨(확인용)
    // private TestService testService;

    @Autowired                                  // 저장됨(샘플 생성)
    private TestRepository testRepository;

    TestProjectMaster request;

    @BeforeEach
    void setup() {
        request = TestProjectMaster.builder()
                .pmName("프로젝트 테스트")
                .build();
    }

    /*@DisplayName("Mock 테스트")
    @Test
    void MockTest() {
        when(testService.getName()).thenReturn("js");

        mockMvc.perform((get("/hello")))
                .andExpect(content().string("hello js"));

        assertThat(outputCaptureRule.toString()).contains("test");
    }*/

    @DisplayName("Controller 테스트")
    @Test
    @Order(1)
    void controllerTest() {
        // given
        System.out.println(">>> SetUp TestProjectMaster: " + request.toString());

        // when
        TestProjectMaster entity = testRepository.save(request);

        // then
        // assertThat(entity.getPmId()).isNotNull();
    }

    @DisplayName("Repository 테스트")
    @Test
    @Order(2)
    void repositoryTest() {
        System.out.println(">>> SetUp TestProjectMaster: " + request.toString());
        testRepository.save(request);
    }

}
