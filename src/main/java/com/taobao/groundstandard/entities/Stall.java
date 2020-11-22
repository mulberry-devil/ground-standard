/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-09 20:56
 **/

package com.taobao.groundstandard.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stall implements Serializable {
    private String id;
    private String position;
    private String area;
    private String info;
}
