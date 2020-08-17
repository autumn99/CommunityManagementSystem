package cn.com.service.impl;
import cn.com.entity.User;
import cn.com.mapper.UserMapper;
import cn.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selAll() {
        return userMapper.selAll();
    }

    @Override
    public User selByName(String userName) {
        return userMapper.selByName(userName);
    }

    @Override
    public Boolean insertInfo(User user) {
        return userMapper.insertInfo(user);
    }

    @Override
    public Boolean updatePhone(User user) {
        return userMapper.updatePhone(user);
    }

    @Override
    public Boolean updateState(User user) {
        return userMapper.updateState(user);
    }

    @Override
    public Boolean updatePassword(User user) {
        return userMapper.updatePassword(user);
    }

    @Override
    public List<User> selState() {
        return userMapper.selState();
    }

    @Override
    public Boolean updateNumber(User user) {
        return userMapper.updateNumber(user);
    }

    @Override
    public User selByPhone(String userPhone) {
        return userMapper.selByPhone(userPhone);
    }
}
