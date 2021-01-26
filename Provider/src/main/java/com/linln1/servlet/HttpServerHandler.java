package com.linln1.servlet;

import com.linln1.pojo.Invocation;
import com.linln1.pojo.Url;
import com.linln1.registry.NativeRegistry;
import org.apache.commons.io.IOUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class HttpServerHandler {
    public void handle(HttpServletRequest req, HttpServletResponse resp){
        try {
            //通过req流获取服务调用的参数
            InputStream inputStream = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Invocation invocation = (Invocation) objectInputStream.readObject();

            //从注册中心获取服务的列表
            Class implClass = NativeRegistry.get(invocation.getInterfaceName(), new Url("localhost", 8080));



            //反射，调用服务
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String res = (String) method.invoke(implClass.newInstance(), invocation.getParams());

            //返回结果
            IOUtils.write(res, resp.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
