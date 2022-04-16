package com.ddd;

import com.uuu.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//@Mapper
public interface UserMapper {

    List<User> getUsers(@Param("userName") String userName, @Param("age") String age);

    int addUsers(@Param("users") List<User> aaa);

    List<User> getUsersByIds(@Param("ids") Integer[] aaa);

    int deleteByIds(@Param("ids") Integer[] aaa);

    int updateByIds(@Param("ids") Integer[] aaa);

    User getUser();

}
