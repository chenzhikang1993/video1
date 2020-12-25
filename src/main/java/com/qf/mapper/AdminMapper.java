package com.qf.mapper;

import com.qf.pojo.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    Admin selectAdminByUsernameAndPassword(Admin admin);
}
