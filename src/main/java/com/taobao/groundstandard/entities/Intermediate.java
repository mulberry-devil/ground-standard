/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-12 14:52
 **/

package com.taobao.groundstandard.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Intermediate {
    private Long user_id;
    private String stall_id;
    private Date start_time;
    private Date end_time;
    private Integer status;
}
