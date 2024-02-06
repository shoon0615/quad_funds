/**
 * packageName  : com.side_project.quad_funds_bo_all.config.interceptor
 * fileName     : TokenValidInterceptor
 * author       : SangHoon
 * date         : 2024-01-28
 * description  : AOP 접근 log 확인
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-28          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.config.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenValidInterceptor implements HandlerInterceptor {

    /**
     * method       : preHandle
     * author       : SangHoon
     * date         : 2024-01-28 오전 12:48
     * description  : 컨트롤러 접근 전 실행
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("==================== BEGIN ====================");
        log.info("Request URI ===> " + request.getRequestURI());
        return true;
    }

    /**
     * method       : postHandle
     * author       : SangHoon
     * date         : 2024-01-28 오전 12:48
     * description  : 화면(View)에 전달하기 전 실행
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("==================== END ====================");
        request.setAttribute("cartData", 1L);
    }
}
