/**
 * packageName  : com.side_project.quad_funds_bo_all.util.qualifier
 * fileName     : TestJpaService
 * author       : SangHoon
 * date         : 2024-02-06
 * description  : TestService - JPA 버전
 *                문자가 들어간 @Annotation 은 오타나도 컴파일로 알 수 없어 따로 생성
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-06          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.util.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("TestJpaService")
public @interface TestJpaService {
}
