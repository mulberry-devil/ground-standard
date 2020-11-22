/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-09 21:12
 **/

package com.taobao.groundstandard.impl;

import com.taobao.groundstandard.dao.StallMapper;
import com.taobao.groundstandard.entities.Stall;
import com.taobao.groundstandard.services.StallService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class StallImpl implements StallService {

    @Resource
    private StallMapper stallMapper;

    @Override
    public Stall findStallInfo(String stallId) {
        return stallMapper.findStallInfo(stallId);
    }

    @Override
    public Date findETime(String stallId) {
        return stallMapper.findETime(stallId);
    }

    @Override
    public void insertData(Long user_id, String stall_id, Date start_time, Date end_time) {
        stallMapper.insertData(user_id, stall_id, start_time, end_time);
    }

    @Override
    public Long findUId(String stallId) {
        return stallMapper.findUId(stallId);
    }

    @Override
    public void updateDate(String stall_id, Date end_time) {
        stallMapper.updateDate(stall_id,end_time);
    }
}
