package cn.com.mapper;
import	java.util.List;

import cn.com.entity.Security;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SecurityMapper {

    /**
     * 插入安防信息
     * @param security
     * @return
     */
    @Insert("insert into security(securityTitle,securityContents) values(#{securityTitle},#{securityContents})")
    Boolean insertInfo(Security security);

    /**
     * 根据安防id更改安防详情内容
     * @param security
     * @return
     */
    @Update("update security set securityContents=#{securityContents} where securityId=#{securityId}")
    Boolean updateInfo(Security security);

    /**
     * 查询所有安防信息
     * @return
     */
    @Select("select * from security")
    List<Security> selAll();

    /**
     * 根据安防id删除安防信息
     * @param securityId
     * @return
     */
    @Delete("delete from security where securityId =#{securityId}")
    Boolean deleteInfo(int securityId);
}
