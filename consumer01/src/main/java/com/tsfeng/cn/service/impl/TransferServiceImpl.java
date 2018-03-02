package com.tsfeng.cn.service.impl;

import com.tsfeng.cn.service.AccountService;
import com.tsfeng.cn.service.AccountService02;
import com.tsfeng.cn.service.TransferService;
import org.bytesoft.compensable.Compensable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author tsfeng
 * @version 创建时间 2018/3/1 11:21
 */
@Service("transferService")
@Compensable(interfaceClass = TransferService.class)
//        , confirmableKey = "transferServiceConfirm", cancellableKey = "transferServiceCancel")
public class TransferServiceImpl implements TransferService {

    @Resource(name = "normalAccountService")
    private AccountService normalAccountService;

    @Resource(name = "tccAccountService")
    private AccountService tccAccountService;

    @Resource(name = "tccAccountService02")
    private AccountService02 tccAccountService02;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transferTcc(String sourceAcctId, String targetAcctId, double amount) throws Exception {
        System.out.println("远程减begin");
        tccAccountService02.decreaseAmount(sourceAcctId, amount);
        System.out.println("远程减end");

		System.out.println("本地加begin");
		tccAccountService.increaseAmount(targetAcctId, amount);
		System.out.println("本地加end");

    }
}
