package com.qf.service;

import com.qf.pojo.User;

import java.util.Map;

public interface UserService {

    User selectUserByEmailAndPassword(User user);
    public User findByemail(String email);

    public Integer updateByEmail(Map map);

    public Integer updateByEmail2(User user);

    Boolean updateUser(User user);
}
