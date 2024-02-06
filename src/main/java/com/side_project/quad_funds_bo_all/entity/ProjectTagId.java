/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : ProjectTagId
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 프로젝트 태그 PK
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectTagId {

    @Column(name="pm_id")
    private Long pmId;                                      // 프로젝트 ID

    @ColumnDefault("1")
    private Long pdtSequenceNumber = 1L;                    // 순번

}
