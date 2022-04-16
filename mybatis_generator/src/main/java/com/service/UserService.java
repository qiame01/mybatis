package springboot10.service;

import springboot10.pojo.SbTestUser;

import java.util.List;

public interface UserService {
    void addUser(SbTestUser user);

    List<SbTestUser> listUsers();
}
