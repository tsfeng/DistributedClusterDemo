package com.tsfeng.cn.service.impl;

import com.tsfeng.cn.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author tsfeng
 * @version 创建时间 2018/2/10 11:49
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        System.out.println("provider01 test success");
        return "provider01";
    }
}
