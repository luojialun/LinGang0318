package com.lingang.http;

import com.google.gson.Gson;
import com.lzy.okgo.model.HttpParams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/31 0031.
 */

public class ParamsBean extends HttpParams{
    public static String authtoken;
    public static String authid;

    private LinkedHashMap<String,Object> map;

    public ParamsBean(){
       map=new LinkedHashMap<>();
        if(null!=authtoken){
            map.put("authtoken",authtoken);
        }
        if(null!=authid){
            map.put("authid",authid);
        }
    }

    public ParamsBean add(String key,Object value){
        if(map!=null){
            map.put(key,value);
        }
        return this;
    }

    public ParamsBean add(Map<String,Object> pMap){
        if(map!=null){
            map.putAll(pMap);
        }
        return this;
    }

    public String toJsonString(){
        if(map!=null){
            return new Gson().toJson(map);
        }
        return null;
    }
}
