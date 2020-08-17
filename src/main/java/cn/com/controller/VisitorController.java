package cn.com.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import	java.util.HashMap;

import cn.com.entity.Visitor;
import cn.com.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/visitor")
@ResponseBody
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    /**
     * 获取访客信息
     * @return
     */
    @RequestMapping("/getVisitor")
    public List getVisitor(){
        List<Visitor> list =visitorService.selAll();
        return list;
    }

    /**
     * 删除访客信息
     * @param visitorId
     * @return
     */
    @RequestMapping("/deleteInfo")
    public Map deleteInfo(int visitorId){
        Map<String, Object> map = new HashMap<String, Object> ();
        if (visitorService.deleteInfo(visitorId)){
            map.put("msg","删除成功");
        }else {
            map.put("msg","删除失败");
        }
        return  map;
    }

    /**
     * 添加访客信息
     * @param visitor
     * @return
     */
    @RequestMapping("/insertInfo")
    public Map insertInfo(@RequestBody  Visitor visitor){
        Map<String, Object> map = new HashMap<String, Object> ();
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);
        visitor.setVisitorTime(createdate);
        if(visitor.getVisitorName()=="" || visitor.getVisitorPhone()==""){
            map.put("msg","电话或姓名不能为空");
        }else {
            if (visitorService.insertInfo(visitor)){
                map.put("msg","添加成功");
            }else {
                map.put("msg","添加失败");
            }
        }

        return  map;
    }
}
