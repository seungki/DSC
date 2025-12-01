package com.doosanenc.dsc.common.mapper;

import java.util.Collections;

import org.springframework.stereotype.Repository;

import com.doosanenc.dsc.common.model.Role;
import com.doosanenc.dsc.common.model.User;

@Repository
public class UserRepository {


    public User findByUserId(String userId) {
        if ("admin".equals(userId)) {
            User user = new User();
            user.setUserId("admin");
            user.setPassword("$2a$10$unOExKLE.UgVQiMY8iJ1QOgfPLsXN1JAKm3gQFmIK68piazV5GiNC"); // bcrypt hash
            user.setName("관리자");
            user.setEnabled("Y");
            Role role = new Role();
            role.setRoleName("ROLE_ADMIN");
            user.setRoles(Collections.singletonList(role));
            return user;
        } else if ("user".equals(userId)) {
            User user = new User();
            user.setUserId("user");
            user.setPassword("$2a$10$unOExKLE.UgVQiMY8iJ1QOgfPLsXN1JAKm3gQFmIK68piazV5GiNC"); // bcrypt hash
            user.setName("일반 사용자");
            user.setEnabled("Y");
            Role role = new Role();
            role.setRoleName("ROLE_USER");
            user.setRoles(Collections.singletonList(role));
            return user;
        }
        return null;
    }
}