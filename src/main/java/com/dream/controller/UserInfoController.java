package com.dream.controller;

import com.dream.pojo.Person;
import com.dream.service.PersonService;
import com.dream.utils.JwtUtils; // 你的JWT工具类（解析Token）
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserInfoController {
    @Autowired
    private PersonService personService;

    // 前端请求地址：http://localhost:8080/user/info
    @GetMapping("/user/info")
    public Map<String, Object> getUserInfo(@RequestHeader("Authorization") String token) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 1. 去掉Token前缀（如果前端传的是Bearer xxx）
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            // 2. 解析Token获取用户ID（你的JwtUtil工具类要能解析出id）
            Long userId = JwtUtils.getUserIdFromToken(token);
            // 3. 查询用户信息（含role_type）
            Person person = personService.getPersonById(userId);

            result.put("code", 200);
            result.put("msg", "success");
            result.put("data", person); // 返回用户信息（id/account/name/role_type）
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "获取用户信息失败：" + e.getMessage());
        }
        return result;
    }
}