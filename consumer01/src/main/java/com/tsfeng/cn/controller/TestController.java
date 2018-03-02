package com.tsfeng.cn.controller;

import com.tsfeng.cn.service.AccountService;
import com.tsfeng.cn.service.TestService;
import com.tsfeng.cn.service.TransferService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author tsfeng
 * @version 创建时间 2018/2/10 15:00
 */
@Controller
public class TestController {

    @Resource(name="testService")
    private TestService testService;

    @Resource(name="transferService")
    private TransferService transferService;

    @RequestMapping(value = {"/test"})
    @ResponseBody
    public String testDubbo(){
        try {
            transferService.transferTcc("1001", "2001", 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "consuemr01" + testService.test();
    }

}
