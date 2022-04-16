package com.ddd;

import com.uuu.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//@Mapper
public interface UserMapper {

    List<User> getUserList();

    int getCount();

    Map<String, Object> getUserMapById(String id);

    List<Map<String, Object>> getUserMapList();

    @MapKey("id")
    Map<String, Object> getUserMapListWithKey();

    User getUserByLike(String userName);

    List<User> getUsersByPage();
}
