/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : ProjectSave
 * author       : SangHoon
 * date         : 2024-02-05
 * description  : 프로젝트 찜
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

import java.util.Date;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@IdClass(ProjectSaveId.class)
public class ProjectSave extends BaseTimeEntity {

    @Id
    private Long pmId;                                     // 프로젝트 ID

    @MapsId("pmId")
    @ManyToOne
    @JoinColumn(name = "pm_id")
    private ProjectMaster projectMaster;

    @Id
    private Long mmId;                                      // 회원 ID

    @MapsId("mmId")
    @ManyToOne
    @JoinColumn(name = "mm_id")
    private MemberMaster memberMaster;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date pdsSaveDate;                               // 찜 일자

}
