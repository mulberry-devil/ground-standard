/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-09 21:10
 **/

package com.taobao.groundstandard.impl;

import com.taobao.groundstandard.dao.UserMapper;
import com.taobao.groundstandard.entities.User;
import com.taobao.groundstandard.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findById(Long loginId) {
        return userMapper.findById(loginId);
    }

    @Override
    public Integer judge(Long loginId) {
        return userMapper.judge(loginId);
    }

    @Override
    public String getPass(Long loginId) {
        return userMapper.getPass(loginId);
    }

    @Override
    public void success(User user) {
        userMapper.success(user);
    }
}
