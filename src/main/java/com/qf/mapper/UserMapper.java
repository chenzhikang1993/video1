package com.qf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {

    User selectUserByEmailAndPassword(User user);
    public Integer updateByEmail(Map map);

    int updatePasswoedByEmail(String email,String password);

    public Integer updateByEmail2(User user);
}
