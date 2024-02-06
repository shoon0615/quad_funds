/**
 * packageName  : com.side_project.quad_funds_bo_all.repository
 * fileName     : TestRepository
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 테스트 DB 작업
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.repository;

import com.side_project.quad_funds_bo_all.entity.TestProjectMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestProjectMaster, Long> {
}
