/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : MemberDetailSearch
 * author       : SangHoon
 * date         : 2024-02-04
 * description  : 회원 검색 테이블
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-04          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.entity;

import com.side_project.quad_funds_bo_all.util.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@IdClass(MemberDetailSearchId.class)
public class MemberDetailSearch extends BaseTimeEntity {

    @Id
    @Column(name="mm_id")
    private Long mmId;                                      // 회원 ID

    @MapsId("mmId")                                         // FUNDING_DETAIL_PAYMENT 의 mmId
    @ManyToOne
    @JoinColumn(name = "mm_id")                             // MEMBER_MASTER 의 mmId
    private MemberMaster memberMaster;

    @Id
    private String mdsSearchKey;                            // 검색키

    @Id
    private LocalDate mdsSearchDate;                        // 검색 일자

    private Integer mdsSearchCount;                         // 검색 횟수
}
