package com.tsfeng.cn.service.cancel;

import com.tsfeng.cn.service.TransferService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tsfeng
 * @version 创建时间 2018/3/1 11:26
 */
@Service("transferServiceCancel")
public class TransferServiceCancel implements TransferService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void transferTcc(String sourceAcctId, String targetAcctId, double amount) throws Exception {

    }

}
