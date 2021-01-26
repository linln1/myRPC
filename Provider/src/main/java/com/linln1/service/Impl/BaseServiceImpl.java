package com.linln1.service.Impl;

import com.linln1.service.BaseService;

public class BaseServiceImpl implements BaseService {
    public String sayHello(String name) {
        return name + "call myRPC com.linln1.service";
    }
}
