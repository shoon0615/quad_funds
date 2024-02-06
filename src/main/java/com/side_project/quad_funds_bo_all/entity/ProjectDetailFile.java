/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : ProjectDetailFile
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 프로젝트 파일 테이블
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
@IdClass(ProjectDetailFileId.class)
public class ProjectDetailFile extends BaseTimeEntity {

    @Id
    private Long pmId;                                      // 프로젝트 ID

    @MapsId("pmId")
    @ManyToOne
    @JoinColumn(name = "pm_id")
    private ProjectMaster projectMaster;

    @Id
    private Long fmId;                                      // 파일 ID

    @MapsId("fmId")
    @ManyToOne
    @JoinColumn(name = "fm_id")
    private FileMaster fileMaster;

    private String pdfName;                                 // 이름

}
