package com.tsfeng.cn.service.comfirm;

import com.alibaba.fastjson.JSON;
import com.tsfeng.cn.dao.AccountMapper;
import com.tsfeng.cn.model.Account;
import com.tsfeng.cn.service.AccountService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tsfeng
 * @version 创建时间 2018/2/11 13:38
 */
@Service("accountServiceConfirm")
public class TccAccountServiceConfirm implements AccountService02 {

    @Autowired
    AccountMapper accountMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void increaseAmount(String accountId, double amount) throws Exception {
        System.out.println("increaseAmount增加-确认");
        Account account = accountMapper.selectByPrimaryKey(accountId);
        System.out.println(JSON.toJSONString(account));
        account.setFrozen(account.getFrozen() - 1);
        System.out.println(JSON.toJSONString(account));
        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i != 1) {
            throw new Exception(accountId + "增加-确认异常");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void decreaseAmount(String accountId, double amount) throws Exception {
        System.out.println("decreaseAmount减少-确认");
        Account account = accountMapper.selectByPrimaryKey(accountId);
        System.out.println(JSON.toJSONString(account));
        account.setFrozen(account.getFrozen() - 1);
        System.out.println(JSON.toJSONString(account));
        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i != 1) {
            throw new Exception(accountId + "减少-确认异常");
        }
    }
}
