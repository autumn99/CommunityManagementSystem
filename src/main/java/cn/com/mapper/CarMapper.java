package cn.com.mapper;

import cn.com.entity.Car;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CarMapper {

    /**
     * 查询现有车位数量
     * @return
     */
    @Select("select * from car where carId=1")
    Car selNumber();

    /**
     * 更改现有车位数
     * @param num
     * @return
     */
    @Update("update car set carNumber = carNumber+#{num} where carId =1" )
    Boolean updateNumber(int num);

    /**
     * 更改车库信息
     * @param carNews
     * @return
     */
    @Update("update car set carNews = #{carNews} where carId =1")
    Boolean updateNews(String carNews);
}
