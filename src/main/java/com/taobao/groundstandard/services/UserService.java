package com.taobao.groundstandard.services;

import com.taobao.groundstandard.entities.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User findById(@Param("loginId") Long loginId);

    Integer judge(@Param("loginId") Long loginId);

    String getPass(Long loginId);

    void success(User user);
}
