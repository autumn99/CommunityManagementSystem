package cn.com.service.impl;

import cn.com.entity.Car;
import cn.com.mapper.CarMapper;
import cn.com.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public Car selNumber() {
        return carMapper.selNumber();
    }

    @Override
    public Boolean updateNumber(int num) {
        return carMapper.updateNumber(num);
    }

    @Override
    public Boolean updateNews(String carNews) {
        return carMapper.updateNews(carNews);
    }
}
