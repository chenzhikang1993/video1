package com.qf.service;



import com.qf.pojo.Admin;
import org.springframework.stereotype.Service;



public interface AdminService {
    Admin selectAdminByUsernameAndPassword(Admin admin);

}
