/**
 * packageName  : com.side_project.quad_funds_bo_all.controller
 * fileName     : RestTestController
 * author       : SangHoon
 * date         : 2024-01-28
 * description  : 테스트 그룹 > 테스트 관리 RestController
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-28          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.controller;

import com.side_project.quad_funds_bo_all.service.TestService;
import com.side_project.quad_funds_bo_all.util.qualifier.TestMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
// @RequiredArgsConstructor
@RequestMapping("/api/v1/qua/test/mybatis")
public class RestTestMybatisController {

    private TestService testService;

    @Autowired
    public RestTestMybatisController(@TestMybatisService TestService testService) {
        this.testService = testService;
    }

    /**
     * method       : getTest
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:25
     * description  : 테스트 단건 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity getTest(@PathVariable final Long id) {
        return testService.findTest(id);
    }

    /**
     * method       : getTestList
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:25
     * description  : 테스트 목록 조회
     */
    @PostMapping
    public ResponseEntity getTestList(@RequestBody final Map<String, Object> params) {
        return testService.findAllTest(params);
    }

    /**
     * method       : saveTest
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:25
     * description  : 테스트 저장(입력/수정)
     */
    @PutMapping
    public ResponseEntity saveTest(@RequestBody final Map<String, Object> params) {
        return testService.saveTest(params);
    }

    /**
     * method       : deleteTest
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:25
     * description  : 테스트 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTest(@PathVariable final Long id) {
        return testService.findTest(id);
    }

}
