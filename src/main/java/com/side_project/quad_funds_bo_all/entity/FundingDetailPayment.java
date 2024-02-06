/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : FundingDetailPayment
 * author       : SangHoon
 * date         : 2024-02-04
 * description  : 펀딩 결제 테이블
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-04          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.side_project.quad_funds_bo_all.util.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Table(name="FUNDING_DETAIL_PAYMENT")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class FundingDetailPayment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fdpId;                                     // 결제 ID

    @Column(name="pdf_id")
    private Long pdfId;                                     // 펀딩 ID

    @MapsId("pdfId")
    @ManyToOne
    @JoinColumn(name = "pdf_id")
    private ProjectDetailFunding projectDetailFunding;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date fdpPaymentDate;                            // 결제 일자

    private BigDecimal fdpPaymentAmount;                    // 결제 금액
    private String fdpPaymentType;                          // 결제 종류
    private String fdpPaymentCompany;                       // 결제사
    private String fdpPaymentInstallment;                   // 결제 할부개월
    private String fdpBillingKey;                           // 빌링키

    @ColumnDefault("'N'")
    private String fdpRefundYn;                             // 환불 여부

    private String fdpPaymentYn;                            // 결제 여부
    private String fdpPaymentFailReason;                    // 결제 실패 사유

}