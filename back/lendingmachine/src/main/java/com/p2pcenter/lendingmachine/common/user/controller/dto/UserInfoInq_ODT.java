package com.p2pcenter.lendingmachine.common.user.controller.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoInq_ODT {
	private String userName;
	private String nickName;
	private String phoneNo;
	private List<UserInfoInq_GRID_ODT> grid; // acntList
	private String cddYn;
}