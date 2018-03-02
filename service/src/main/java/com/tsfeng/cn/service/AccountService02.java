package com.tsfeng.cn.service;

/**
 * @author tsfeng
 * @version 创建时间 2018/2/11 11:22
 */
public interface AccountService02 {

    /**
     * 增加金额
     * @param accountId 账户
     * @param amount 金额
     * @throws Exception e
     */
    public void increaseAmount(String accountId, double amount) throws Exception;

    /**
     * 减少金额
     * @param accountId 账户
     * @param amount 金额
     * @throws Exception e
     */
    public void decreaseAmount(String accountId, double amount) throws Exception;
}
