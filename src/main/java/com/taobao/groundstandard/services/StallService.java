/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-09 21:10
 **/

package com.taobao.groundstandard.services;

import com.taobao.groundstandard.entities.Stall;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface StallService {
    Stall findStallInfo(@Param("stallId") String stallId);

    Date findETime(@Param("stallId") String stallId);

    void insertData(@Param("user_id") Long user_id, @Param("stall_id") String stall_id,
                    @Param("start_time") Date start_time, @Param("end_time") Date end_time);

    Long findUId(@Param("stallId") String stallId);

    void updateDate(@Param("stall_id") String stall_id,@Param("end_time") Date end_time);
}
