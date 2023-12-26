package com.p2pcenter.lendingmachine.common.user.controller.dto;

import java.util.List;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoInq_ODT {
	private String userId;
	private String userName;
	private String password;
	private String nickName;
	private String phoneNo;
	private List<UserInfoInq_GRID_ODT> grid; // acntList
	private String cddYn;
}