package cn.com.controller;
import	java.util.HashMap;
import	java.util.Map;

import cn.com.entity.Car;
import cn.com.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/car")
@ResponseBody
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * 查询停车场信息
     * @return
     */
    @RequestMapping("/getCar")
    public Car getCar(){
        Car car = carService.selNumber();
        return car;
    }

    /**
     * 更改车辆进出数量
     * @param num
     * @return
     */
    @RequestMapping("/updateNumber")
    public Map updateNumber(int num){
        Map<String, Object> map = new HashMap<String, Object> ();
        System.out.println("num="+num);
        if (carService.updateNumber(num)){
            map.put("msg","修改成功");
        }else {
            map.put("msg","修改失败");
        }
        return map;
    }

    /**
     * 更改停车场公告
     * @param news
     * @return
     */
    @RequestMapping("/updateNews")
    public Map updateNews(String news){
        Map<String, Object> map = new HashMap<String, Object> ();
        System.out.println("news="+news);
        if (carService.updateNews(news)){
            map.put("msg","修改成功");
        }else {
            map.put("msg","修改失败");
        }
        return map;
    }
}
