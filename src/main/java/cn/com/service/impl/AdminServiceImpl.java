package cn.com.service.impl;

import cn.com.entity.Admin;
import cn.com.mapper.AdminMapper;
import cn.com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Boolean insertInfo(Admin admin) {
        return adminMapper.insertInfo(admin);
    }

    @Override
    public Boolean delete(int adminId) {
        return adminMapper.delete(adminId);
    }

    @Override
    public Boolean updateInfo(Admin admin) {
        return adminMapper.updateInfo(admin);
    }

    @Override
    public List<Admin> selAll() {
        return adminMapper.selAll();
    }

    @Override
    public Admin selByName(String adminName) {
        return adminMapper.selByName(adminName);
    }
}
