package cn.com.service.impl;

import cn.com.entity.Security;
import cn.com.mapper.SecurityMapper;
import cn.com.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private SecurityMapper securityMapper;

    @Override
    public Boolean insertInfo(Security security) {
        return securityMapper.insertInfo(security);
    }

    @Override
    public Boolean updateInfo(Security security) {
        return securityMapper.updateInfo(security);
    }

    @Override
    public List<Security> selAll() {
        return securityMapper.selAll();
    }

    @Override
    public Boolean deleteInfo(int securityId) {
        return securityMapper.deleteInfo(securityId);
    }
}
