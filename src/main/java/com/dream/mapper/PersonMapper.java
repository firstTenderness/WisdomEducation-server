package com.dream.mapper;

import com.dream.pojo.LoginRequest;
import com.dream.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface PersonMapper {
    @Select("select id,account,name,role_type from person where account=#{account} and password=#{password}")
    Person getUsernameAndPassword(LoginRequest loginRequest);
    // 新增：根据ID查询用户信息（含role_type）
    @Select("select id, account, name, role_type from person where id = #{id}")
    Person getPersonById(Long id);
}
