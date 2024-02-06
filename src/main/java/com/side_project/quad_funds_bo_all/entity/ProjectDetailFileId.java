/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : ProjectDetailFileId
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 프로젝트 파일 테이블 PK
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectDetailFileId {

    @Column(name="pm_id")
    private Long pmId;                                      // 프로젝트 ID

    @Column(name="fm_id")
    private Long fmId;                                      // 파일 ID

}
