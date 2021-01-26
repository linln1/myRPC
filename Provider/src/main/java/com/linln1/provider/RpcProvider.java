package com.linln1.provider;

import com.linln1.pojo.Url;
import com.linln1.registry.NativeRegistry;
import com.linln1.service.BaseService;
import com.linln1.service.Impl.BaseServiceImpl;
import com.linln1.servlet.MyHttpServlet;
import org.apache.catalina.startup.Tomcat;

public class RpcProvider {
    public static void main(String[] args) {
        Url url = new Url("localhost", 8080);
        NativeRegistry.regist(BaseService.class.getName(), url, BaseServiceImpl.class);
        
        {
            MyHttpServlet myHttpServlet = new MyHttpServlet();
            myHttpServlet.start(url.getHostname(), url.getPort());
        }
    }
}
