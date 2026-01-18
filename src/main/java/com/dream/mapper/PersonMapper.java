package com.dream.mapper;

import com.dream.pojo.LoginRequest;
import com.dream.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface PersonMapper {
    @Select("select id,account,name from person where account=#{account} and password=#{password}")
    Person getUsernameAndPassword(LoginRequest loginRequest);
}
