package com.ddd;

import com.uuu.User;

//@Mapper
public interface UserMapper {
    User selectUserById(String id);
}
