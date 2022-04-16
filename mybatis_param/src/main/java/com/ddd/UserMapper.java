package com.ddd;

import com.uuu.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//@Mapper
public interface UserMapper {
    User selectUserByUserName1(String userName);

    User selectUserByUserName2(String userName);

    User selectUserByTableName(String tableName, String userName);

    User selectUserByCommon(@Param("userName") String userName, @Param("age") String age);
//    User selectUserByCommon(String userName, String age);

    User selectUserByMap(Map<String, Object> map);

    int insertUser(User user);

    int insertUsers(@Param("users") List<User> aaa);

}
