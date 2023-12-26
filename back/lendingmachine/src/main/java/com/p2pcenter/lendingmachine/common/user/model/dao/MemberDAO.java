package com.p2pcenter.lendingmachine.common.user.model.dao;

import com.p2pcenter.lendingmachine.common.user.controller.dto.UserInfoInq_IDT;
import com.p2pcenter.lendingmachine.common.user.controller.dto.UserInfoInq_ODT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addMember(UserInfoInq_IDT input) {
        String query = "INSERT INTO MEMBER (USER_ID, USER_PW, USER_NAME, PHONE_NO, CDD_YN) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query, input.getUserId(), input.getPassword(), "", "", "Y");
    }
    public List<UserInfoInq_ODT> getAllMembers() {
        String query = "SELECT * FROM MEMBER";

        return jdbcTemplate.query(query, (rs, rowNum) -> {
            UserInfoInq_ODT member = new UserInfoInq_ODT();

            member.setUserName(rs.getString("USER_NAME"));
            member.setUserId(rs.getString("USER_ID"));
            member.setPhoneNo(rs.getString("PHONE_NO"));
            member.setPassword(rs.getString("USER_PW"));
            return member;
        });
    }
}
