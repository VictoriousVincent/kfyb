package com.icbc.bjfh.kfyb.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/QryGov")
public class QueryGovInfoController {
	
	Logger logger = LoggerFactory.getLogger(QueryGovInfoController.class);
	
	@Value("${govurl}")
	private String govUrl;
	
    @RequestMapping(value = "/getTaskOUList")
    public JSONObject getTaskOUList() {
        String url = govUrl + "/selfserviceou/getTaskOUList";
        
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("centerguid", "36271581-6327-4e35-9c5d-26abdc95c2f2");
        sendMap.put("applyertype", "20");
        sendMap.put("currentpage", "0");
        sendMap.put("pagesize", "12");
        
        //发送json
        JSONObject sendJsonObject = new JSONObject();
        sendJsonObject.put("token", "token");
        sendJsonObject.put("params",sendMap);
        logger.info(sendJsonObject.toJSONString());
        //请求报文头
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        //请求体，包括请求数据 body+请求头 headers
        HttpEntity<String> formEntity = new HttpEntity<String>(sendJsonObject.toString(), headers);
        
        try {
            ResponseEntity<String> strbody = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);
			//解析返回的数据
            JSONObject jsTemp = JSONObject.parseObject(strbody.getBody());
            System.out.println(jsTemp.toJSONString());
            return jsTemp;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
