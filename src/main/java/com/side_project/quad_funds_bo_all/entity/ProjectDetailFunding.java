/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : ProjectDetailFunding
 * author       : SangHoon
 * date         : 2024-02-05
 * description  :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.side_project.quad_funds_bo_all.util.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ProjectDetailFunding extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pdfId;                                     // 펀딩 ID

    @Column(name="pm_id")
    private Long pmId;                                      // 프로젝트 ID

    @MapsId("pmId")
    @ManyToOne
    @JoinColumn(name = "pm_id")
    private ProjectMaster projectMaster;

    @Column(name="mm_id")
    private Long mmId;                                      // 회원 ID

    @MapsId("mmId")
    @OneToOne
    @JoinColumn(name = "mm_id")
    private MemberMaster memberMaster;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date pdfApplicationDate;                        // 신청 일자

    private BigDecimal pdfAmount;                           // 금액

    private String pdfCancelYn;                             // 취소 여부
    private String pdfCancelReason;                         // 취소 사유

}
