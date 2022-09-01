package com.example.springbootvueproduct.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description: 日志切面
 * @Author: Luck
 * @Date: 2022/8/31
 */
@Slf4j
@Component
@Aspect
public class LogAspect {

  @Pointcut("execution(* com.example.springbootvueproduct.service.user.*.*(..))")
  public void pointcut1(){
  }

  @Before(value = "pointcut1()")
  public void before(JoinPoint jp){
    String name = jp.getSignature().getName();
    log.info("{}方法开始执行。。。",name);
  }

  @After(value = "pointcut1()")
  public void after(JoinPoint jp){
    String name = jp.getSignature().getName();
    log.info("{}方法执行结束。。。",name);
  }

  @AfterReturning(value = "pointcut1()",returning = "result")
  public void afterReturning(JoinPoint jp,Object result){
    String name = jp.getSignature().getName();
    log.info("{}方法返回值：{}",name, JSON.toJSONString(result));
  }

  @AfterThrowing(value = "pointcut1()",throwing = "e")
  public void afterThrowing(JoinPoint jp,Exception e){
    String name = jp.getSignature().getName();
    log.info("{}方法抛出异常：{}",name, e.getMessage());
  }

  @Around("pointcut1()")
  public Object around(ProceedingJoinPoint pjp) throws Throwable {
    return pjp.proceed();
  }
}
