package cn.com.mapper;
import	java.util.List;

import cn.com.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AdminMapper {

    /**
     * 添加物业人员
     * @param admin
     * @return
     */
    @Insert("insert into admin (adminName,adminPassword,adminPhone,adminState) " +
            " values(#{adminName},#{adminPassword},#{adminPhone},#{adminState})")
    Boolean insertInfo(Admin admin);

    /**
     * 根据物业人员id删除物业人员信息
     * @param adminId
     * @return
     */
    @Delete("delete from admin where adminId=#{adminId}")
    Boolean delete(int adminId);

    /**
     * 根据物业人员id修改物业人员信息
     * @param admin
     * @return
     */
    @Update("update admin set adminPassword=#{adminPassword},adminPhone=#{adminPhone},adminState=#{adminState} where adminName=#{adminName}")
    Boolean updateInfo(Admin admin);

    /**
     * 查询所有物业人员信息
     * @return
     */
    @Select("select * from admin")
    List<Admin> selAll();

    /**
     * 根据姓名查询信息
     * @param adminName
     * @return
     */
    @Select("select * from admin where adminName=#{adminName}")
    Admin selByName(String adminName);
}
