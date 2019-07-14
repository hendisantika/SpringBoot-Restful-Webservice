package com.hendisantika.springbootrestfulwebservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-14
 * Time: 08:31
 */
@Data
@AllArgsConstructor
public class ServiceResponse {
    private Boolean success;
    private String message;
    private Map<String, Object> params;

    public ServiceResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
        this.params = new HashMap<>();
    }

    public void addParam(String key, Object value) {
        params.put(key, value);
    }

}
