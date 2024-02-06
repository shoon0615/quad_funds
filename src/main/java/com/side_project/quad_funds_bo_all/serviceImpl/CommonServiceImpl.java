/**
 * packageName  : com.side_project.quad_funds_bo_all.serviceImpl
 * fileName     : CommonServiceImpl
 * author       : SangHoon
 * date         : 2024-01-28
 * description  : 공통 ServiceImpl(구현체)
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-28          SangHoon             최초 생성
 */
package com.side_project.quad_funds_bo_all.serviceImpl;

import com.side_project.quad_funds_bo_all.service.CommonService;
import com.side_project.quad_funds_bo_all.util.RestTemplateAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    // WebClient 로 변경 예정
    private final RestTemplateAdapter apiAdapter;

    @Value("${api-url}")
    private String apiUrl;

    @Override
    public ResponseEntity sendRequest(Map<String, Object> request) {
        return apiAdapter.commonSend(request);
    }

    @Override
    public ResponseEntity sendGet(String url) {
        return apiAdapter.commonSend(apiUrl + url, HttpMethod.GET, null);
    }

    @Override
    public ResponseEntity sendGetList(String url, Map<String, Object> request) {
        return apiAdapter.commonSend(apiUrl + url, HttpMethod.GET, request);
    }

    @Override
    public ResponseEntity sendPost(String url, Map<String, Object> request) {
        return apiAdapter.commonSend(apiUrl + url, HttpMethod.POST, request);
    }

    @Override
    public ResponseEntity sendPut(String url, Map<String, Object> request) {
        return apiAdapter.commonSend(apiUrl + url, HttpMethod.PUT, request);
    }

    @Override
    public ResponseEntity sendDelete(String url) {
        return apiAdapter.commonSend(apiUrl + url, HttpMethod.DELETE, null);
    }
}
