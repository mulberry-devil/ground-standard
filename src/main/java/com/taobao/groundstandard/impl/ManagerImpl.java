/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-09 21:11
 **/

package com.taobao.groundstandard.impl;

import com.taobao.groundstandard.dao.ManagerMapper;
import com.taobao.groundstandard.entities.Intermediate;
import com.taobao.groundstandard.entities.Stall;
import com.taobao.groundstandard.services.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ManagerImpl implements ManagerService {

    @Resource
    private ManagerMapper managerMapper;

    @Override
    public List<Stall> stallInfo(Long loginId) {
        return managerMapper.stallInfo(loginId);
    }

    @Override
    public List<Intermediate> useInfo(Long loginId) {
        return managerMapper.useInfo(loginId);
    }

    @Override
    public void updateInfo(Integer integral, Long userId) {
        managerMapper.updateInfo(integral,userId);
    }

    @Override
    public void updateStatus(Date startTime, Long userId) {
        managerMapper.updateStatus(startTime,userId);
    }

    @Override
    public void insertStall(Stall stall) {
        managerMapper.insertStall(stall);
    }

    @Override
    public String findManage(Long loginId) {
        return managerMapper.findManage(loginId);
    }

    @Override
    public Stall findStall(String stallId) {
        return managerMapper.findStall(stallId);
    }

    @Override
    public void updateStall(Stall stall) {
        managerMapper.updateStall(stall);
    }

    @Override
    public void deleteStall(String stallId) {
        managerMapper.deleteStall(stallId);
    }
}
