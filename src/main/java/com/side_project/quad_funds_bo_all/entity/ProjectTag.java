/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : ProjectTag
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 프로젝트 태그
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.entity;

import com.side_project.quad_funds_bo_all.util.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@IdClass(ProjectTagId.class)
public class ProjectTag extends BaseTimeEntity {

    @Id
    private Long pmId;                                      // 프로젝트 ID

    @MapsId("pmId")
    @ManyToOne
    @JoinColumn(name = "pm_id")
    private ProjectMaster projectMaster;

    @Id
    @Builder.Default()
    private Long pdtSequenceNumber = 1L;                    // 순번

}
