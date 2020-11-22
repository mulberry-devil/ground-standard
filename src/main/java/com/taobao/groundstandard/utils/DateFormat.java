/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-10 18:23
 **/

package com.taobao.groundstandard.utils;

import java.util.Calendar;
import java.util.Date;

public class DateFormat {
    // 获取三小时后的时间
    public Date getDate(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.HOUR, 3);
        Date end_time = instance.getTime();
        return end_time;
    }

    // 判断摊位的状态
    public boolean dateStatus(Date now_time, Date find_time) {
        boolean status = true;
        // now_time在find_time之后时返回true
        status = now_time.after(find_time);
        return status;
    }
}
