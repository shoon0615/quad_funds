/**
 * packageName  : com.side_project.quad_funds_bo_all.serviceImpl
 * fileName     : TestJpaServiceImpl
 * author       : SangHoon
 * date         : 2024-01-28
 * description  : 테스트 그룹 > 테스트 관리 ServiceImpl(구현체)
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-28          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.serviceImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.side_project.quad_funds_bo_all.entity.TestProjectMaster;
import com.side_project.quad_funds_bo_all.repository.TestRepository;
import com.side_project.quad_funds_bo_all.service.TestService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
// @Primary                 // @Autowired 의 Default 설정
@RequiredArgsConstructor
@Qualifier("TestJpaService")
public class TestJpaServiceImpl implements TestService {

    // inDto 를 outDto 로 convert -> outDto = mapper.convertValue(inDto, new TypeReference<>() {});
    private final ObjectMapper mapper;              // 단, inDto 를 entity 로 convert 해도 영속성 적용 안 됨
    private final TestRepository testRepository;

    @Transactional
    @Override
    public ResponseEntity findTest(final Long id) {
        // default: Optional<Entity> 데이터로 return 되어 변환 필요
        // .get()       : Entity 로 반환(id 를 못찾으면 에러 발생)
        // .orElse()    : Entity 로 반환(id 를 못찾으면 default 처리) -> else 가 발생안해도 else 안의 내용 실행됨
        // .orElseGet() : Entity 로 반환(id 를 못찾으면 default 처리) -> else 가 발생했을때만 else 안의 내용 실행됨
        // .orElseThrow(): Entity 로 반환(id 를 못찾으면 지정한 exception 발생)
        TestProjectMaster entity = testRepository.findById(id).orElseGet(null);
        return ResponseEntity.ok(entity);
    }

    @Transactional
    @Override
    public ResponseEntity findAllTest(final Map<String, Object> request) {
        return ResponseEntity.ok(testRepository.findAll());
    }

    @Transactional
    @Override
    public ResponseEntity saveTest(final Map<String, Object> request) {
        TestProjectMaster entity = mapper.convertValue(request, new TypeReference<>() {});
        return ResponseEntity.ok(testRepository.save(entity));
    }

    @Transactional
    @Override
    public ResponseEntity deleteTest(final Long id) {
        testRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

}