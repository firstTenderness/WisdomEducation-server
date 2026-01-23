package com.dream.service.impl;

import com.dream.mapper.PersonMapper;
import com.dream.pojo.LoginInfo;
import com.dream.pojo.LoginRequest;
import com.dream.pojo.Person;
import com.dream.service.PersonService;
import com.dream.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dream.service.PersonService;

import java.util.HashMap;

@Service
public class PersonServiceimpl implements PersonService {
    @Autowired
   private PersonMapper personMapper;
    @Override
    public LoginInfo login(LoginRequest loginRequest) {
 Person personlogin=personMapper.getUsernameAndPassword(loginRequest);
 if (personlogin!=null){
     HashMap<String, Object> claims = new HashMap<>();
     claims.put("id", personlogin.getId());
     claims.put("account", personlogin.getAccount());
     claims.put("name", personlogin.getName());
     claims.put("password", personlogin.getPassword());
     claims.put("role_type", personlogin.getRoleType());
     String jwt = JwtUtils.generateJwt(claims);

     return new LoginInfo(personlogin.getId(),
             personlogin.getAccount(),
             personlogin.getName(),
             personlogin.getRoleType(),jwt);
 }
 return null;
    }
    @Override
    public Person getPersonById(Long id) {
        return personMapper.getPersonById(id);
    }
}
