package com.taobao.groundstandard.dao;

import com.taobao.groundstandard.entities.Stall;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface StallMapper {
    Stall findStallInfo(@Param("stallId") String stallId);

    Date findETime(@Param("stallId") String stallId);

    void insertData(@Param("user_id") Long user_id, @Param("stall_id") String stall_id,
                    @Param("start_time") Date start_time, @Param("end_time") Date end_time);

    Long findUId(@Param("stallId") String stallId);

    void updateDate(@Param("stall_id") String stall_id,@Param("end_time") Date end_time);
}
