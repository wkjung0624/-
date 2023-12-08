package com.p2pcenter.lendingmachine.common.user.controller;

import com.p2pcenter.lendingmachine.common.user.service.UserInfoInq_SVC;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.p2pcenter.lendingmachine.common.user.controller.dto.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserInfoInq_CTR {
	private final UserInfoInq_SVC userInfoInqSvc;

	@ResponseBody
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody UserInfoInq_IDT input, HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("userInfo") != null) {
			return ResponseEntity.ok().build();
		} else {
			UserInfoInq_ODT output = userInfoInqSvc.getUserInfo(input);

			if (output != null) {
				session.setAttribute("userInfo", output);
				return ResponseEntity.ok().build();
			}
		}

		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@ResponseBody
	@PostMapping("/info")
	public ResponseEntity getUserInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("userInfo") == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

		UserInfoInq_ODT output = (UserInfoInq_ODT) session.getAttribute("userInfo");

		return ResponseEntity.ok(output);
	}
}