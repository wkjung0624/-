package com.p2pcenter.lendingmachine.bank.controller;

import com.p2pcenter.lendingmachine.bank.controller.dto.FrnrCurrency_IDT;
import com.p2pcenter.lendingmachine.bank.service.FrnrCurrency_SVC;
import com.p2pcenter.lendingmachine.common.user.service.UserInfoInq_SVC;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/currency")
public class FrnrCurrency_CTR {
	private final FrnrCurrency_SVC frnrCurrencySvc;

	@ResponseBody
	@PostMapping("/noticeExchangeRate")
	public ResponseEntity getNoticeExchangeRate(@RequestBody FrnrCurrency_IDT input) throws IOException, InterruptedException {
		return ResponseEntity.ok(frnrCurrencySvc.getNoticeExchangeRate(input));
	}
}