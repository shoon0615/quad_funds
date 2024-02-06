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

import com.side_project.quad_funds_bo_all.service.CommonService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/qua/sample")
public class RestSampleController {

    private final CommonService commonService;

    /**
     * method       : getTest
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:25
     * description  : 테스트 단건 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity getTest(HttpServletRequest request, @PathVariable final Long id) {
        String url = request.getRequestURI();
        return commonService.sendGet(url);
    }

    /**
     * method       : getTestList
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:25
     * description  : 테스트 목록 조회
     */
    @PostMapping
    public ResponseEntity getTestList(HttpServletRequest request, @RequestBody final Map<String, Object> params) {
        String url = request.getRequestURI();
        return commonService.sendPost(url, params);
    }

    /**
     * method       : saveTest
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:25
     * description  : 테스트 저장(입력/수정)
     */
    @PutMapping
    public ResponseEntity saveTest(HttpServletRequest request, @RequestBody final Map<String, Object> params) {
        String url = request.getRequestURI();
        return commonService.sendPut(url, params);
    }

    /**
     * method       : deleteTest
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:25
     * description  : 테스트 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTest(HttpServletRequest request, @PathVariable final Long id) {
        String url = request.getRequestURI();
        return commonService.sendDelete(url);
    }

    /**
     * method       : getTest
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:25
     * description  : 테스트 동적 작업
     */
    @RequestMapping("/test")
    public ResponseEntity getTest() {
        return commonService.sendRequest(null);
    }

}
