package com.p2pcenter.lendingmachine.bank.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Withdraw_IDT {
    private String fromAcntNo;
    private String toAcntNo;
    private String balance;
}
