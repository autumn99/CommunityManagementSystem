package cn.com.mapper;

import cn.com.entity.News;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsMapper {

    /**
     * 添加公告信息
     * @param news
     * @return
     */
    @Insert("insert into news (newsTitle,newsContents,newsTime,newsName)  " +
            "values(#{newsTitle},#{newsContents},#{newsTime},#{newsName})")
    Boolean interInfo(News news);

    /**
     * 查询公告信息,根据id降序排列
     * @return
     */
    @Select("select * from news order by newsId desc")
    List<News> selAll();

    /**
     * 根据标题删除公告信息
     * @param newsId
     * @return
     */
    @Delete("delete from news where newsId = #{newsId}")
    Boolean deleteById(int newsId);
}
