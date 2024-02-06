/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : ProjectDetailBill
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 프로젝트 정산 테이블
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
public class ProjectDetailBill extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pdbId;                                     // 정산 ID

    @Column(name="pm_id")
    private Long pmId;                                      // 프로젝트 ID

    @MapsId("pmId")
    @OneToOne
    @JoinColumn(name = "pm_id")
    private ProjectMaster projectMaster;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date mdsBillDate;                               // 정산 일자

    private BigDecimal mdsBillAmount;                       // 정산 금액

    private String mdsPaymentYn;                            // 결제 여부
    private String mdsPaymentFailReason;                    // 결제 실패 사유

}
