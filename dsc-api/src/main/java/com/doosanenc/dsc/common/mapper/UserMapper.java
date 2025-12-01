package com.doosanenc.dsc.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.doosanenc.dsc.common.model.User;

@Mapper
public interface UserMapper {
    User findByUserId(String userId);
}
