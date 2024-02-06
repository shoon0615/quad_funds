/**
 * packageName  : com.side_project.quad_funds_bo_all.enumeration
 * fileName     : BaseTimeEntity
 * author       : SangHoon
 * date         : 2024-01-28
 * description  : 공통 Date 컬럼 Listener
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-28          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.util.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass                               // 필드들을 column 으로 인식시켜줌
@EntityListeners(AuditingEntityListener.class)  // BaseTimeEntity 클래스에 Auditing 기능을 포함
public class BaseTimeEntity {

    @ColumnDefault("'Y'")
    @Column(nullable = false)
    private String deleteYn = "N";              // 삭제여부

    /*@Convert(converter = BooleanToYnConverter.class)
    @Column(nullable = false)
    private Boolean deleteYn = false;           // 삭제여부*/

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;          // 생성일자

    @LastModifiedDate
    private LocalDateTime modifiedDate;         // 수정일자

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
