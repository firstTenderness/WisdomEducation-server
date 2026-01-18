package com.dream.controller;

import com.dream.pojo.LoginInfo;
import com.dream.pojo.LoginRequest;
import com.dream.pojo.Result;
import com.dream.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class loginController {
@Autowired
    private PersonService personService;
@PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        log.info("用户登录，参数：account={},password={}",
                loginRequest.getAccount(), loginRequest.getPassword());
   LoginInfo loginInfo= personService.login(loginRequest);
   if (loginInfo != null){
       log.info("用户登录成功，结果：{}", loginInfo);
       return Result.success(loginInfo);
   }
        return Result.error("登录失败,用户名或者密码错误");
    }
}
