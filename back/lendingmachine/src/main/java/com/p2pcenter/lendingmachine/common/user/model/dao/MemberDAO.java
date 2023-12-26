package com.p2pcenter.lendingmachine.common.user.model.dao;

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
