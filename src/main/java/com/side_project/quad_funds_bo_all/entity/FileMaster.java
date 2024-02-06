/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : FileMaster
 * author       : SangHoon
 * date         : 2024-02-05
 * description  :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.entity;

import com.side_project.quad_funds_bo_all.util.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class FileMaster extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fmId;                                      // 파일 ID

    @ColumnDefault("1")
    @Builder.Default
    private Long fmSequenceNumber = 1L;                     // 순번

    private String fmOriginalFileName;                      // 원본 파일 이름
    private String fmChangeFileName;                        // 변환 파일 이름
    private String fmFileExtension;                         // 파일 확장자
    private String fmFileVolume;                            // 파일 용량
    private String fmFileLocation;                          // 파일 경로

}
