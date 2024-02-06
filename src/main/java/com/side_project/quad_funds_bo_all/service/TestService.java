/**
 * packageName  : com.side_project.quad_funds_bo_all.service
 * fileName     : TestService
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 테스트 그룹 > 테스트 관리 Service
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface TestService {

    /* 단건 조회 */
    ResponseEntity findTest(Long id);

    /* 리스트 조회 */
    ResponseEntity findAllTest(Map<String, Object> request);

    /* 저장(입력/수정) */
    ResponseEntity saveTest(Map<String, Object> request);

    /* 삭제 */
    ResponseEntity deleteTest(Long id);

}
