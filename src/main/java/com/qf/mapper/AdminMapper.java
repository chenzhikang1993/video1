package com.qf.mapper;

import com.qf.pojo.Admin;
import org.springframework.stereotype.Repository;

////茹东杰
//@Repository
//public interface AdminMapper {
//
//    Admin selectAdmin(Admin admin);

@Repository
public interface AdminMapper {
    Admin selectAdminByUsernameAndPassword(Admin admin);

}
