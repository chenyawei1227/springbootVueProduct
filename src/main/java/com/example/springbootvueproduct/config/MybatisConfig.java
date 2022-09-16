package com.example.springbootvueproduct.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: mybatis配置类
 * @License: <p>https://www.hexcloud.cn</p> <p>上海合阔信息技术有限公司</p>
 * @Author: Luck
 * @Date: 2022/9/1
 */
@Configuration
@MapperScan("com.example.springbootvueproduct.mapper")
public class MybatisConfig {

}
