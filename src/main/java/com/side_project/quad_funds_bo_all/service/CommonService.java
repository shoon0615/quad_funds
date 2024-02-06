/**
 * packageName  : com.side_project.quad_funds_bo_all.service
 * fileName     : CommonService
 * author       : SangHoon
 * date         : 2024-01-28
 * description  : 공통 Service
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-28          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CommonService {

    /**
     * method       : sendRequest
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:37
     * description  : API 통신(동적)
     */
    ResponseEntity sendRequest(Map<String, Object> request);

    /**
     * method       : sendGet
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:37
     * description  : API GET 통신(조회 - 단건)
     */
    ResponseEntity sendGet(String url);

    /**
     * method       : sendGetList
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:37
     * description  : API GET 통신(조회 - 목록)
     */
    ResponseEntity sendGetList(String url, Map<String, Object> request);

    /**
     * method       : sendPost
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:37
     * description  : API POST 통신
     */
    ResponseEntity sendPost(String url, Map<String, Object> request);

    /**
     * method       : sendPut
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:37
     * description  : API PUT 통신(저장 - 입력/수정)
     */
    ResponseEntity sendPut(String url, Map<String, Object> request);

    /**
     * method       : sendDelete
     * author       : SangHoon
     * date         : 2024-01-28 오전 1:37
     * description  : API DELETE 통신(삭제)
     */
    ResponseEntity sendDelete(String url);

}
