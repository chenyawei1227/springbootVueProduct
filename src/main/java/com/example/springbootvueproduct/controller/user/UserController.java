package com.example.springbootvueproduct.controller.user;

import com.example.springbootvueproduct.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Luck
 * @Date: 2022/9/1
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/getUserById")
  public String getUserById(Integer id){
    return userService.getUserById(id);
  }

  @GetMapping("/deleteUserById")
  public void deleteUserById(Integer id){
    userService.deleteUserById(id);
  }

}
