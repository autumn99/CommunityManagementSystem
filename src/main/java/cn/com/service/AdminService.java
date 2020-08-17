package cn.com.service;

import cn.com.entity.Admin;

import java.util.List;

public interface AdminService {

    /**
     * 添加物业人员
     * @param admin
     * @return
     */
    Boolean insertInfo(Admin admin);

    /**
     * 根据物业人员id删除物业人员信息
     * @param adminId
     * @return
     */
    Boolean delete(int adminId);

    /**
     * 根据物业人员id修改物业人员信息
     * @param admin
     * @return
     */
    Boolean updateInfo(Admin admin);

    /**
     * 查询所有物业人员信息
     * @return
     */
    List<Admin> selAll();

    /**
     * 根据姓名查询信息
     * @param adminName
     * @return
     */
    Admin selByName(String adminName);
}
