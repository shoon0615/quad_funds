/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : MemberDetailSearchId
 * author       : SangHoon
 * date         : 2024-02-04
 * description  : 회원 검색 테이블 PK
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-04          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDetailSearchId {

    private Long mmId;                                      // 회원 ID
    private String mdsSearchKey;                            // 검색키

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private LocalDate mdsSearchDate;                        // 검색 일자

}
