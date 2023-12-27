package com.p2pcenter.lendingmachine.bank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankAccountDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BankAccountDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BankAccount> getAllAccountInquiry(String userId){
        String query = "SELECT * FROM ACCOUNT WHERE MBR_ID = (SELECT MBR_ID FROM MEMBER WHERE USER_ID LIKE ?)";

        return jdbcTemplate.query(query, new Object[]{userId}, (rs, rowNum) -> {
            BankAccount bankAccount = new BankAccount();

            bankAccount.setAcntNo(rs.getString("ACNT_NO"));
            bankAccount.setBkGbn(rs.getString("BK_GBN"));
            bankAccount.setBalance(rs.getString("BALANCE"));
            bankAccount.setAcntName(rs.getString("ACNT_NAME"));
            bankAccount.setBlockYn(rs.getString("BLOCK_YN"));

            return bankAccount;
        });
    }
}
