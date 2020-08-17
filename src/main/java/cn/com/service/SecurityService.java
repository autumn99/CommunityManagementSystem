package cn.com.service;

import cn.com.entity.Security;

import java.util.List;

public interface SecurityService {

    /**
     * 插入安防信息
     * @param security
     * @return
     */
    Boolean insertInfo(Security security);

    /**
     * 根据安防id更改安防详情内容
     * @param security
     * @return
     */
    Boolean updateInfo(Security security);

    /**
     * 查询所有安防信息
     * @return
     */
    List<Security> selAll();

    /**
     * 根据安防id删除安防信息
     * @param securityId
     * @return
     */
    Boolean deleteInfo(int securityId);
}
