package com.restAssured.frameworks.bodyBuilder;

import org.json.simple.JSONObject;

public class ReqBodyBuilder {

    public String createUserReqBody(String name, String gender, String email, String status ){
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", name); // Cast
        requestParams.put("gender",gender );
        requestParams.put("email", email);
        requestParams.put("status", status);
        return requestParams.toJSONString();
    }

    public String updateUserUrl(String baseUrl, String id ){
        String finalUrl = baseUrl + id;
        return finalUrl;
    }
}
