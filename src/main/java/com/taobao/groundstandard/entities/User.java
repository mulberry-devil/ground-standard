/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-09 20:49
 **/

package com.taobao.groundstandard.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long id;
    private String password;
    private String name;
    private String phone;
    private Integer sex;
    private Integer integral;
}
