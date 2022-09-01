package com.example.springbootvueproduct.runner;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description: 项目启动时会执行
 * 
 * @Author: Luck
 * @Date: 2022/8/31
 */
@Slf4j
@Component
public class MyCommandLineRunner1 implements CommandLineRunner {

  @Override
  @Order(1)
  public void run(String... args) throws Exception {
    log.info("CommandLineRunner1->>{}", Arrays.toString(args));
  }
}
