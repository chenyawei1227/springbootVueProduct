package com.example.springbootvueproduct.service.user;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Luck
 * @Date: 2022/8/31
 */
@Service
public class UserService {

  public String getUserById(Integer id){
    int i = 100 / id;
    System.out.println("get...."+i);
    return "user: "+i;
  }

  public void deleteUserById(Integer id){
    System.out.println("delete...."+id);
  }

}
