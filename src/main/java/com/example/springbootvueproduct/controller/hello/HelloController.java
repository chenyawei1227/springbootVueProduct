package com.example.springbootvueproduct.controller.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @License: <p>https://www.hexcloud.cn</p> <p>上海合阔信息技术有限公司</p>
 * @Author: Luck
 * @Date: 2022/9/16
 */
@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello(){
    return "Hello";
  }
}
