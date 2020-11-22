/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-09 22:09
 **/

package com.taobao.groundstandard.config;

import com.taobao.groundstandard.component.MyWebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new MyWebMvcConfigurer();
    }
}
