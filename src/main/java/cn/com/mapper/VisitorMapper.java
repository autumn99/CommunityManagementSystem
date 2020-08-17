package cn.com.mapper;
import cn.com.entity.Visitor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import	java.util.List;

public interface VisitorMapper {

    /**
     * 查询所有的访客信息
     * @return
     */
    @Select("select * from visitor")
    List<Visitor> selAll();

    /**
     * 添加访客信息
     * @param visitor
     * @return
     */
    @Insert("insert into visitor (visitorName,visitorPhone,visitorTime) " +
            " values(#{visitorName},#{visitorPhone},#{visitorTime})")
    Boolean insertInfo(Visitor visitor);

    /**
     * 根据访客id删除访客信息
     * @param visitorId
     * @return
     */
    @Delete("delete from visitor where visitorId =#{visitorId}")
    Boolean deleteInfo(int visitorId);
}
