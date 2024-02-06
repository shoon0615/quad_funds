/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : ProjectMaster
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 프로젝트 마스터
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
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class TestProjectMaster extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pmId;                                      // 프로젝트 ID

    private String pmCategory;                              // 카테고리

    @Column(nullable = false)
    private String pmName;                                  // 이름

    private BigDecimal pmTargetAmount;                      // 목표 금액

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date pmTargetDate;                              // 목표 일자

    private String pmTargetType;                            // 목표 종류
    private String pmTargetCompleteYn;                      // 목표 달성 여부

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date pmStartDate;                               // 시작 일자

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date pmEndDate;                                 // 종료 일자

    private String pmApprovalYn;                            // 승인 여부
    private String pmRatePlan;                              // 요금제
    private String pmRefundPossibleYn;                      // 환불 가능 여부
    private String pmReservationPossibleYn;                 // 예약 가능 여부
    private String pmMainImage;                             // 기본 이미지

}
