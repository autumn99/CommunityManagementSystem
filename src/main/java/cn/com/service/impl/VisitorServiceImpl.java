package cn.com.service.impl;

import cn.com.entity.Visitor;
import cn.com.mapper.VisitorMapper;
import cn.com.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorMapper visitorMapper;


    @Override
    public List<Visitor> selAll() {
        return visitorMapper.selAll();
    }

    @Override
    public Boolean insertInfo(Visitor visitor) {
        return visitorMapper.insertInfo(visitor);
    }

    @Override
    public Boolean deleteInfo(int visitorId) {
        return visitorMapper.deleteInfo(visitorId);
    }
}
