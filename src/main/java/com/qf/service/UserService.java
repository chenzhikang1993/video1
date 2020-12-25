package com.qf.service;

import com.qf.pojo.User;

public interface UserService {

    User selectUserByEmailAndPassword(User user);

}
