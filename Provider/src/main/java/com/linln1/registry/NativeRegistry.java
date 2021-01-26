package com.linln1.registry;

import com.linln1.pojo.Url;

import java.util.HashMap;
import java.util.Map;

public class NativeRegistry {

    private static Map<String, Map<Url, Class>> registCenter = new HashMap<String, Map<Url, Class>>();

    public static void regist(String name, Url url, Class implClass){
        Map<Url, Class> map = new HashMap<Url, Class>();
        map.put(url, implClass);
        registCenter.put(name, map);
    }

    public static Class get(String name, Url url){
        Map<Url, Class> urlClassMap = registCenter.get(name);
        Class implClass = urlClassMap.get(url);
        return implClass;
    }
}
