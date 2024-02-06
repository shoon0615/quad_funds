/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : MemberMaster
 * author       : SangHoon
 * date         : 2024-02-04
 * description  : 회원 마스터 테이블
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
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MemberMaster extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mmId;                                      // 회원 ID

    @Column(nullable = false)
    private String mmName;                                  // 이름

    private String mmAuthorization;                         // 권한

    @Column(length = 11)
    private Integer mmPhoneNumber;                          // 연락처

    private String mmEmail;                                 // 이메일

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date mmBirth;                                   // 생년월일

    // @Column(columnDefinition = "CHECK (mm_gender IN ('M', 'W')")
    @Check(constraints = "mm_gender IN ('M', 'W')")
    private String mmGender;                                // 성별

    private String mmZipCode;                               // 우편번호

    @Column(length = 2000)
    private String mmBaseAddress;                           // 기본 주소

    @Column(length = 2000)
    private String mmDetailAddress;                         // 상세 주소

    @ColumnDefault("'N'")
    private String mmResignYn;                              // 탈퇴 여부

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date mmResignDate;                              // 탈퇴 일자

    @Column(length = 2000)
    private String mmResignReason;                          // 탈퇴 사유

    // @Convert(converter = BooleanToYnConverter.class)
    private Boolean mmAlarmYn;                              // 알림 여부

    private String mmEventAgreeYn;                          // 이벤트 수신 동의여부

}
