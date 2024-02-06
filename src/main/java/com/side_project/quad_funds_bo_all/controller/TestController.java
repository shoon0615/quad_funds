/**
 * packageName  : com.side_project.quad_funds_bo_all.controller
 * fileName     : TestController
 * author       : SangHoon
 * date         : 2024-01-28
 * description  : 테스트 그룹 > 테스트 관리 Controller
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-28          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
// @RequestMapping("/qua/test")
@RequestMapping("/qua/{menu}")
public class TestController {

    // private final String viewPath = "/qua/test";
    private final String viewPath = "/qua/";

    /**
     * method       : view
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:25
     * description  : 테스트 메뉴
     */
    @GetMapping("/{view}")
    public String view(Model model, @PathVariable String menu, @PathVariable String view) {
        return getViewPath(menu, view);
    }

    /**
     * method       : sample
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:25
     * description  : (삭제 예정)
     */
    @GetMapping("/sample/{view}")
    public String sample(Model model, @PathVariable final String view) {
        return "/test/" + view;
    }

    // TODO: (임시)
    private String getViewPath(String menu, String view) {
        // return viewPath + menu + "/" + view;
        StringBuilder sb = new StringBuilder(viewPath);
        sb.append(menu).append("/").append(view);
        return sb.toString();
    }

}