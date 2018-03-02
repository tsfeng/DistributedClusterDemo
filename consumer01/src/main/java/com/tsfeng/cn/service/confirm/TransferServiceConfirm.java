package com.tsfeng.cn.service.confirm;

import com.tsfeng.cn.service.TransferService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tsfeng
 * @version 创建时间 2018/3/1 11:25
 */
@Service("transferServiceConfirm")
public class TransferServiceConfirm implements TransferService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void transferTcc(String sourceAcctId, String targetAcctId, double amount) throws Exception {

    }
}
