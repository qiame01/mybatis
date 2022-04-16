package com.ddd;

import com.uuu.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getByPage() {
        List<User> result = userMapper.getUsersByPage();
        return result;
    }
}
