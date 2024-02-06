/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : ProjectQna
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 프로젝트 Q&A
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
public class ProjectQna extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pdqId;                                     // Q&A ID

    @Column(name="pm_id")
    private Long pmId;                                      // 프로젝트 ID

    @MapsId("pmId")
    @ManyToOne
    @JoinColumn(name = "pm_id")
    private ProjectMaster projectMaster;

    @Column(name="mm_id")
    private Long mmId;                                      // 회원 ID

    @MapsId("mmId")
    @ManyToOne
    @JoinColumn(name = "mm_id")
    private MemberMaster memberMaster;

    @Column(nullable = false)
    private String pdqTitle;                                // 제목

    private String pdqContents;                             // 내용
    private String pdqAnswerContents;                       // 답변

}
