package com.taobao.groundstandard.dao;

import com.taobao.groundstandard.entities.Intermediate;
import com.taobao.groundstandard.entities.Stall;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ManagerMapper {

    List<Stall> stallInfo(@Param("loginId") Long loginId);

    List<Intermediate> useInfo(@Param("loginId") Long loginId);

    void updateInfo(@Param("integral") Integer integral,@Param("userId") Long userId);

    void updateStatus(@Param("startTime") Date startTime, @Param("userId") Long userId);

    void insertStall(Stall stall);

    String findManage(Long loginId);

    Stall findStall(String stallId);

    void updateStall(Stall stall);

    void deleteStall(String stallId);
}
