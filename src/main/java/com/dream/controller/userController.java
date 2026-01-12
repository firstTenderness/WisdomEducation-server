package com.dream.controller;

import com.dream.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@Slf4j
@RestController
public class userController {
@GetMapping
    public Result page(){
    log.info("page");
    return Result.success();
}
}
