package com.ddd;

import com.uuu.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectUserById(String id);
}
