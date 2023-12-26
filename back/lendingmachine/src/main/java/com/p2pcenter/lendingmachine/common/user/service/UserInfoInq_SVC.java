package com.p2pcenter.lendingmachine.common.user.service;

import com.p2pcenter.lendingmachine.common.user.controller.dto.UserInfoInq_GRID_ODT;
import com.p2pcenter.lendingmachine.common.user.controller.dto.UserInfoInq_IDT;
import com.p2pcenter.lendingmachine.common.user.controller.dto.UserInfoInq_ODT;
import com.p2pcenter.lendingmachine.common.user.model.dao.MemberDAO;
import jakarta.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class UserInfoInq_SVC {

	private final MemberDAO memberDAO;

	public UserInfoInq_ODT getUserInfo(UserInfoInq_IDT input){
		List<UserInfoInq_ODT> allItems = memberDAO.getAllMembers();

		for (UserInfoInq_ODT item : allItems) {
			System.out.println(item.getUserId() + " " + input.getUserId());
			System.out.println(item.getPassword() + " " + input.getPassword());
			if (item.getUserId().equals(input.getUserId()) &&
				item.getPassword().equals(input.getPassword())) {

				return item;
			}
		}

		return null;

//		if ("admin".equals(input.getUsername()) && "pwd123".equals(input.getPassword())) {
//			List<UserInfoInq_GRID_ODT> adminAcnts = new LinkedList<>();
//
//			UserInfoInq_GRID_ODT grid[] = new UserInfoInq_GRID_ODT[3];
//
//			grid[0] = UserInfoInq_GRID_ODT
//				.builder()
//				.acntName("우리SUPER우대적금")
//				.balance(new BigInteger("589005120"))
//				.blockYn("N")
//				.acntNo("1002464365579")
//				.build();
//			grid[1] = UserInfoInq_GRID_ODT
//				.builder()
//				.acntName("조흥급여통자")
//				.balance(new BigInteger("1250900"))
//				.blockYn("Y")
//				.acntNo("59011259995")
//				.build();
//			grid[2] = UserInfoInq_GRID_ODT
//				.builder()
//				.acntName("신한SOL한예금")
//				.balance(new BigInteger("500010"))
//				.blockYn("N")
//				.acntNo("1906435579")
//				.build();
//
//			adminAcnts.add(grid[0]);
//			adminAcnts.add(grid[1]);
//			adminAcnts.add(grid[2]);
//
//			return UserInfoInq_ODT
//				.builder()
//					.userName(input.getUsername())
//					.nickName("관리자1")
//					.phoneNo("01033334444")
//					.grid(adminAcnts)
//					.cddYn("Y")
//				.build();
//		}
//
//		return null;
	}
}