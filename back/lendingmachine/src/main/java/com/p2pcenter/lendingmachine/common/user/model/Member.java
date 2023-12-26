package com.p2pcenter.lendingmachine.common.user.model;

import com.p2pcenter.lendingmachine.common.user.controller.dto.UserInfoInq_GRID_ODT;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
public class Member {

    private String userName;
    private String nickName;
    private String phoneNo;
    private String cddYn;
}