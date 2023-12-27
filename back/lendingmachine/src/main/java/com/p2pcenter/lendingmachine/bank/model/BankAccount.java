package com.p2pcenter.lendingmachine.bank.model;

import lombok.Data;

@Data
public class BankAccount {
    private int acntId;
    private int mbrId;
    private String acntNo;
    private String bkGbn;
    private String balance;
    private String acntName;
    private String blockYn;
}
