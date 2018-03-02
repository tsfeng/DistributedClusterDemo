package com.tsfeng.cn.service.impl;

import com.alibaba.fastjson.JSON;
import com.tsfeng.cn.dao.AccountMapper;
import com.tsfeng.cn.model.Account;
import com.tsfeng.cn.service.AccountService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tsfeng
 * @version 创建时间 2018/2/11 11:26
 */
@Service("accountService01")
@Compensable(interfaceClass = AccountService.class, confirmableKey = "accountServiceConfirm", cancellableKey = "accountServiceCancel")
public class TccAccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void increaseAmount(String accountId, double amount) throws Exception {
        System.out.println("increaseAmount增加");
        Account account = accountMapper.selectByPrimaryKey(accountId);
        System.out.println(JSON.toJSONString(account));
        account.setFrozen(account.getFrozen() + 1);
        System.out.println(JSON.toJSONString(account));
        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i != 1) {
            throw new Exception(accountId + "增加异常");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void decreaseAmount(String accountId, double amount) throws Exception {
        System.out.println("decreaseAmount减少");
        Account account = accountMapper.selectByPrimaryKey(accountId);
        System.out.println(JSON.toJSONString(account));
        account.setAmount(account.getAmount() - amount);
        account.setFrozen(account.getFrozen() + 1);
        System.out.println(JSON.toJSONString(account));
        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i != 1) {
            throw new Exception(accountId + "减少异常");
        }
    }
}
