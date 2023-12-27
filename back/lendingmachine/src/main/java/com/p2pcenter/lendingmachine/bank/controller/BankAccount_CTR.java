package com.p2pcenter.lendingmachine.bank.controller;


import com.p2pcenter.lendingmachine.bank.controller.dto.FrnrCurrency_IDT;
import com.p2pcenter.lendingmachine.bank.controller.dto.Withdraw_IDT;
import com.p2pcenter.lendingmachine.bank.service.BankAccount_SVC;
import com.p2pcenter.lendingmachine.common.user.controller.dto.UserInfoInq_ODT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/account")
public class BankAccount_CTR {
    private final BankAccount_SVC bankAccountSvc;

    @ResponseBody
    @PostMapping("/inquiry")
    public ResponseEntity getAllAccountInquiry(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserInfoInq_ODT output = (UserInfoInq_ODT) session.getAttribute("userInfo");

        return ResponseEntity.ok(bankAccountSvc.getAllAccountInquiry(output.getUserId()));
    }

    @ResponseBody
    @PostMapping("/withdraw")
    public ResponseEntity withdraw(@RequestBody Withdraw_IDT input, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserInfoInq_ODT output = (UserInfoInq_ODT) session.getAttribute("userInfo");

        // 보내는 계좌 소유주 검증 필요
        int status = bankAccountSvc.withdrawWithAcntNo(input.getFromAcntNo(), input.getToAcntNo(), input.getBalance());

        if (status == 1) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
}