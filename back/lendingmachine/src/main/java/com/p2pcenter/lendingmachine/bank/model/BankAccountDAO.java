package com.p2pcenter.lendingmachine.bank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
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
    public int withdrawWithAcntNo(String from, String to, String balance) {
        String balanceQuery = "SELECT * FROM ACCOUNT WHERE ACNT_NO LIKE ?";
        String withdrawQuery = "UPDATE ACCOUNT SET BALANCE = ? WHERE ACNT_NO LIKE ?";

        BankAccount fromAcnt = jdbcTemplate.query(balanceQuery, new Object[]{from}, (rs, rowNum) -> {
            BankAccount bankAccount = new BankAccount();

            bankAccount.setAcntNo(rs.getString("ACNT_NO"));
            bankAccount.setBkGbn(rs.getString("BK_GBN"));
            bankAccount.setBalance(rs.getString("BALANCE"));
            bankAccount.setAcntName(rs.getString("ACNT_NAME"));
            bankAccount.setBlockYn(rs.getString("BLOCK_YN"));

            return bankAccount;
        }).get(0);

        BankAccount toAcnt = jdbcTemplate.query(balanceQuery, new Object[]{to}, (rs, rowNum) -> {
            BankAccount bankAccount = new BankAccount();

            bankAccount.setAcntNo(rs.getString("ACNT_NO"));
            bankAccount.setBkGbn(rs.getString("BK_GBN"));
            bankAccount.setBalance(rs.getString("BALANCE"));
            bankAccount.setAcntName(rs.getString("ACNT_NAME"));
            bankAccount.setBlockYn(rs.getString("BLOCK_YN"));

            return bankAccount;
        }).get(0);

        BigInteger fromBalance = new BigInteger(fromAcnt.getBalance());
        BigInteger toBalance = new BigInteger(toAcnt.getBalance());
        BigInteger amount = new BigInteger(balance);

        if (fromBalance.subtract(amount).compareTo(BigInteger.ZERO) >= 0) {
            jdbcTemplate.update(withdrawQuery, fromBalance.subtract(amount), from);
            jdbcTemplate.update(withdrawQuery, toBalance.add(amount), to);
            return 1;
        } else {
            return 0;
        }
    }
}
