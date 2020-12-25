package com.qf.service.impl;

import com.qf.mapper.AdminMapper;
import com.qf.pojo.Admin;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//茹东杰
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin selectAdmin(Admin admin) {
        return  adminMapper.selectAdmin(admin);

    }
}
