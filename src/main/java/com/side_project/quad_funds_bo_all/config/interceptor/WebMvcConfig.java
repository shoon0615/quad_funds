/**
 * packageName  : com.side_project.quad_funds_bo_all.config.interceptor
 * fileName     : WebMvcConfig
 * author       : SangHoon
 * date         : 2024-01-28
 * description  : AOP 적용 대상 설정
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-28          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.config.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final TokenValidInterceptor tokenValidInterceptor;

    /**
     * method       : addInterceptors
     * author       : SangHoon
     * date         : 2024-01-28 오전 12:48
     * description  : AOP Interceptor 기본 설정
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenValidInterceptor)
//                .addPathPatterns("/**")                                       // 해당 패턴들만 인터셉터 적용 -> addPathPatterns 메소드 없을 시 전체 적용
//                .excludePathPatterns("/css/**", "/images/**", "/js/**");      // 해당 패턴의 주소/경로는 인터셉터 호출에서 제외
                .excludePathPatterns("/assets/**");
    }

    /**
     * method       : addCorsMappings
     * author       : SangHoon
     * date         : 2024-01-28 오전 12:49
     * description  : CORS 관련 보안 설정
     */
    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("HEAD", "OPTIONS", "PATCH", "GET", "PUT", "POST", "DELETE")
                .allowedHeaders("*")
                .maxAge(600);
    }*/
}
