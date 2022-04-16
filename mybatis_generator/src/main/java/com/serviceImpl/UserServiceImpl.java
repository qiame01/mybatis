package springboot10.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot10.mapper.SbTestUserMapper;
import springboot10.pojo.SbTestUser;
import springboot10.pojo.SbTestUserExample;
import springboot10.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SbTestUserMapper mapper;

    @Override
    public void addUser(SbTestUser user) {
        int insert = mapper.insert(user);
    }

    @Override
    public List<SbTestUser> listUsers() {
        SbTestUserExample example = new SbTestUserExample();
        return mapper.selectByExample(example);
    }
}
