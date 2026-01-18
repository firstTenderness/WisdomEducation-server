package com.dream.service;

import com.dream.pojo.LoginInfo;
import com.dream.pojo.LoginRequest;

public interface PersonService {
    LoginInfo login(LoginRequest loginRequest);
}
