/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : ProjectSaveId
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 프로젝트 찜 PK
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectSaveId {

    @Column(name="pm_id")
    private Long pmId;                                      // 프로젝트 ID

    @Column(name="mm_id")
    private Long mmId;                                      // 회원 ID

}
