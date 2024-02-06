/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : ProjectReview
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 프로젝트 리뷰
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.entity;

import com.side_project.quad_funds_bo_all.util.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ProjectReview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pdrId;                                     // 리뷰 ID

    @MapsId("pmId")
    @ManyToOne
    @JoinColumn(name = "pm_id")
    private ProjectMaster projectMaster;

    @Column(name="pm_id")
    private Long pmId;                                      // 프로젝트 ID

    @MapsId("mmId")
    @ManyToOne
    @JoinColumn(name = "mm_id")
    private MemberMaster memberMaster;

    @Column(name="mm_id")
    private Long mmId;                                      // 회원 ID

    @Column(length = 2000)
    private String pdrContents;                             // 내용

    @Check(constraints = "pdr_rating BETWEEN 1 AND 5 ")
    private Integer pdrRating;                              // 평점

}
