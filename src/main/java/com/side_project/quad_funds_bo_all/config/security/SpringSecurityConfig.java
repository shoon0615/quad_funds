/**
 * packageName  : com.side_project.quad_funds_bo_all.config.security
 * fileName     : TokenValidInterceptor
 * author       : SangHoon
 * date         : 2024-01-28
 * description  : SpringSecurity 보안 및 접근(인증 권한) 체크
 *                Spring 3.0 이상 버전은 WebSecurityConfigurerAdapter 미존재
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-28          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.config.security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    /**
     * method       : filterChain
     * author       : SangHoon
     * date         : 2024-01-28 오전 12:47
     * description  : SpringSecurity 기본 설정
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http.csrf().disable().cors().disable()       // Spring 3.0.6 까지는 허용됐으나 그 이상은 직렬 메서드 체이닝 지양
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/**" ).permitAll()                    // TODO: (임시) 테스트 환경에선 전체 허용
                        /*.requestMatchers(
                                "/test/main"
                                , "/api/v1/test/**"
                        ).permitAll()*/                   // 해당 url 은 인증 불필요
                        .anyRequest().authenticated()	// 그 외 모든 요청들은 인증 필요
                )
                .formLogin(login -> login	            // form 방식 로그인 사용
                        .defaultSuccessUrl("/test/main", true)	// 성공 시 이동할 url 주소
                        .permitAll()	                // 성공 url 이동이 막히면 안되므로 얘는 허용
                )
                .logout(Customizer.withDefaults());	    // 로그아웃은 기본설정으로 (/logout 으로 인증해제)
        return http.build();
    }

    /**
     * method       : webSecurityCustomizer
     * author       : SangHoon
     * date         : 2024-01-28 오전 12:47
     * description  : 인증 체크 제외 설정
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/h2-console/**")
                .requestMatchers("/css/**", "/images/**", "/js/**");        // 인증 체크에서 제외될 주소/경로
    }

    /**
     * method       : passwordEncoder
     * author       : SangHoon
     * date         : 2024-01-28 오전 12:45
     * description  : 패스워드 암호화 관련 메소드
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
