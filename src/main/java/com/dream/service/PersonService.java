package com.dream.service;

import com.dream.pojo.LoginInfo;
import com.dream.pojo.LoginRequest;
import com.dream.pojo.Person;

public interface PersonService {
    LoginInfo login(LoginRequest loginRequest);
    Person getPersonById(Long id);
}
