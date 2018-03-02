package com.tsfeng.cn.service;

/**
 * @author tsfeng
 * @version 创建时间 2018/3/1 11:19
 */
public interface TransferService {

    /**
     * 本地转账业务-支持事务回滚
     * @param sourceAcctId
     * @param targetAcctId
     * @param amount
     * @throws Exception
     */
    public void transferTcc(String sourceAcctId, String targetAcctId, double amount) throws Exception;

}
