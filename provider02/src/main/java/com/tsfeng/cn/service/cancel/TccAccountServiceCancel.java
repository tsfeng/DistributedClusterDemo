package com.tsfeng.cn.service.cancel;

import com.alibaba.fastjson.JSON;
import com.tsfeng.cn.dao.AccountMapper;
import com.tsfeng.cn.model.Account;
import com.tsfeng.cn.service.AccountService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tsfeng
 * @version 创建时间 2018/2/11 13:40
 */
@Service("accountServiceCancel")
public class TccAccountServiceCancel implements AccountService02 {

    @Autowired
    AccountMapper accountMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void increaseAmount(String accountId, double amount) throws Exception {
        System.out.println("increaseAmount增加-回滚");
        Account account = accountMapper.selectByPrimaryKey(accountId);
        System.out.println(JSON.toJSONString(account));
        account.setAmount(account.getAmount() - amount);
        System.out.println(JSON.toJSONString(account));
        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i != 1) {
            throw new Exception(accountId + "增加-回滚异常");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void decreaseAmount(String accountId, double amount) throws Exception {
        System.out.println("decreaseAmount减少-回滚");
        Account account = accountMapper.selectByPrimaryKey(accountId);
        System.out.println(JSON.toJSONString(account));
        account.setAmount(account.getAmount() + amount);
        System.out.println(JSON.toJSONString(account));
        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i != 1) {
            throw new Exception(accountId + "减少-回滚异常");
        }
    }
}
