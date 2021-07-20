package com.streamlet.chain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Linxz
 * 创建日期：2021年07月19日 2:28 PM
 * version：
 * 描述：
 */
public class Request {

    private Map<String,Object> params =new HashMap<>();

    private Request(){}

    private Request(Map<String,Object> params){
        this.params = params;
    }

    public Map<String,Object> getParams(){
        return params;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private Map<String,Object> params =new HashMap<>();

        public Builder setParams(String key,Object value){
            params.put(key,value);
            return this;
        }

        public Request build(){
            return new Request(params);
        }

    }

}
