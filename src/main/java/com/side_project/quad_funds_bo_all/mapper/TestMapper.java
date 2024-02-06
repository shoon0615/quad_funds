/**
 * packageName  : com.side_project.quad_funds_bo_all.mapper
 * fileName     : TestMapper
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 테스트 그룹 > 테스트 관리 Mapper(DB)
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {

    Map<String, Object> selectTest(Map<String, Object> request);
    List<Map<String, Object>> selectAllTest(Map<String, Object> request);
    int insertTest(Map<String, Object> request);
    int updateTest(Map<String, Object> request);
    int saveTest(Map<String, Object> request);
    int deleteTest(Map<String, Object> request);

}
