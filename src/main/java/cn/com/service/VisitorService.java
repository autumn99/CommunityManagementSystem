package cn.com.service;

import cn.com.entity.Visitor;

import java.util.List;

public interface VisitorService {

    /**
     * 查询所有的访客信息
     * @return
     */
    List<Visitor> selAll();

    /**
     * 添加访客信息
     * @param visitor
     * @return
     */
    Boolean insertInfo(cn.com.entity.Visitor visitor);

    /**
     * 根据访客id删除访客信息
     * @param visitorId
     * @return
     */
    Boolean deleteInfo(int visitorId);
}
