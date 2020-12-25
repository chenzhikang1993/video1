package com.qf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.mapper.UserMapper;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByEmailAndPassword(User user) {
        return userMapper.selectUserByEmailAndPassword(user);
    }

    @Override
    public User findByemail(String email) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        //User user = userMapper.selectOne(wrapper);

        return userMapper.selectOne(wrapper);
    }

    @Override
    public Integer updateByEmail(Map map) {
        //userMapper.updateByEmail(map)
        return userMapper.updateByEmail(map);
    }

    @Override
    public Integer updateByEmail2(User user) {
        return userMapper.updateByEmail2(user);
    }

    @Override
    public int updatePasswoedByEmail(String email,String password) {
        return userMapper.updatePasswoedByEmail(email,password);
    }
}
