package com.tsfeng.cn.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tsfeng
 * @version 创建时间 2018/2/11 14:59
 */
@Data
public class Account implements Serializable{

    private static final long serialVersionUID = -5827727577338898355L;

    private String acct_id;

    private double amount;

    private double frozen;
}
