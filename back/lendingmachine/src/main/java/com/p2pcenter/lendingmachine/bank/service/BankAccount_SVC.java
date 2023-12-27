package com.p2pcenter.lendingmachine.bank.service;

import com.p2pcenter.lendingmachine.bank.model.BankAccount;
import com.p2pcenter.lendingmachine.bank.model.BankAccountDAO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BankAccount_SVC {

    private final BankAccountDAO bankAccountDAO;

    public List<BankAccount> getAllAccountInquiry(String userId) {
        return  bankAccountDAO.getAllAccountInquiry(userId);
    }
}
