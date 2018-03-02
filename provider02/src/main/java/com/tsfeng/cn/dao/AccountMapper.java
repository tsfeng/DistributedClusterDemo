package com.tsfeng.cn.dao;

import com.tsfeng.cn.model.Account;

/**
 * @author tsfeng
 * @version 创建时间 2018/2/11 14:54
 */
public interface AccountMapper {

    /**
     * 根据主键查询账户
     * @param id 主键
     * @return 账户信息
     */
    Account selectByPrimaryKey(String id);

    /**
     * 根据主键更新账户
     * @param account
     * @return
     */
    int updateByPrimaryKeySelective(Account account);
}
