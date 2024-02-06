/**
 * packageName  : com.side_project.quad_funds_bo_all.entity
 * fileName     : TestEntity
 * author       : SangHoon
 * date         : 2024-01-28
 * description  : Test 테이블 Entity
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-28          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.entity;

import com.side_project.quad_funds_bo_all.util.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
// @Setter                      // 데이터의 정합성을 위해 직접 Set 처리 금지(+어디서 변경했는지 식별이 어려움) -> 메소드 생성
@Table(name="TEST")             // 만들어낼 테이블명(default: 클래스명) -> Snake Case 로 name 작명해야함
// @DynamicUpdate               // 변경한 필드만 대응
@Entity
// 기본 생성자(access: 생성자의 접근 권한, protected: Entity 생성이 외부에서 불가능) = protected Test() {}와 동일
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// @AllArgsConstructor          // 전체 매개변수의 생성자가 생성됨(또한 순서 보장이 안됨)
// @Builder                     // 모든 매개변수를 입력 가능함(작업되면 안되는 변수가 포함됨) -> @AllArgsConstructor 도 세트로 필요함
public class TestEntity extends BaseTimeEntity {

    @Id                                                     // = Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 자동으로 PK 1씩 증가
    private Long id;

    @Column(length = 500, nullable = false)                 // VARCHAR(500) 형식, Not Null
    private String title;

    // @Column(columnDefinition = "TEXT", nullable = false) // TEXT 형식(길이 제한 없음)
    @Column(nullable = false)
    private String content;

    private String author;                                  // @Column 어노테이션 안붙일 경우 default 로 변수명 적용

    @ColumnDefault("0")                                     // DDL 생성 시 default 설정
    // @Builder.Default()
    private int hits = 0;                                   // @Builder 생성 시 default 값

    @Builder
    public TestEntity(Long id, String title, String content, String author, int hits, Long fileId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.hits = hits;
    }

    // update 테스트
    public void update(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 조회 수 증가
    public void increaseHits() {
        this.hits++;
    }

}