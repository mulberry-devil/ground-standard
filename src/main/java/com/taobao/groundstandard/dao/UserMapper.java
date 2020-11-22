package com.taobao.groundstandard.dao;

import com.taobao.groundstandard.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findById(@Param("loginId") Long loginId);

    Integer judge(@Param("loginId") Long loginId);

    String getPass(Long loginId);

    void success(User user);
}
