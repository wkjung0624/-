package com.p2pcenter.lendingmachine.common.user.controller.dto;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoInq_GRID_ODT {
	private String acntName;
	private String acntNo;
	private BigInteger balance;
	private String blockYn;
}
