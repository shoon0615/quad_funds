/**
 * packageName  : com.side_project.quad_funds_bo_all.serviceImpl
 * fileName     : TestMybatisServiceImpl
 * author       : SangHoon
 * date         : 2024-01-28
 * description  : 테스트 그룹 > 테스트 관리 ServiceImpl(구현체)
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-28          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.serviceImpl;

import com.side_project.quad_funds_bo_all.mapper.TestMapper;
import com.side_project.quad_funds_bo_all.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Qualifier("TestMybatisService")
public class TestMybatisServiceImpl implements TestService {

    private final TestMapper testMapper;

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity findTest(final Long id) {
        // ProjectMaster request = ProjectMaster.builder().pmId(id).build();
        Map<String, Object> request = Map.of("pmId", id);
        Map<String, Object> response = testMapper.selectTest(request);

        // if("".equals(response.getOrDefault("pmId", ""))) {
        /*if(ObjectUtils.isEmpty(response)) {
            throw new Exception();
        }*/

        return ResponseEntity.ok(response);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity findAllTest(final Map<String, Object> request) {
        return ResponseEntity.ok(testMapper.selectAllTest(request));
    }

    @Override
    public ResponseEntity saveTest(final Map<String, Object> request) {
        int result = 0;
        if(request.get("pmId") == null) {
            result = testMapper.insertTest(request);
        } else {
            Map<String, Object> response = testMapper.selectTest(request);

            /*if(ObjectUtils.isEmpty(response)) {
                throw new Exception();                      // (선택) 1. 에러 발생
                result = testMapper.insertTest(request);    // (선택) 2. MERGE INTO 작업
            }*/

            result = testMapper.updateTest(request);
        }

        if(result == 0) {
            // return ResponseEntity.badRequest().body("fail");
            // throw new Exception("fail");                 // ResponseEntity.ok 외엔 모두 에러발생하게 바뀌어 ExceptionHandler 적용 예정
        }

        // return ResponseEntity.ok(testMapper.saveTest(request));  // MERGE INTO 작업
        return ResponseEntity.ok("success");
    }

    @Override
    public ResponseEntity deleteTest(final Long id) {
        Map<String, Object> request = Map.of("pmId", id);
        int result = testMapper.deleteTest(request);

        if(result == 0) {
            // TODO: 처리 예정
        }

        // return ResponseEntity.ok(testMapper.deleteTest(request));
        return ResponseEntity.ok("success");
    }

}