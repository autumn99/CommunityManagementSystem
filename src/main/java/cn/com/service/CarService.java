package cn.com.service;

import cn.com.entity.Car;

public interface CarService {

    /**
     * 查询现有车位数量
     * @return
     */
    Car selNumber();

    /**
     * 更改现有车位数
     * @param num
     * @return
     */
    Boolean updateNumber(int num);

    /**
     * 更改车库信息
     * @param carNews
     * @return
     */
    Boolean updateNews(String carNews);
}
