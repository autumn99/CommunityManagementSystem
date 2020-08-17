package cn.com.controller;

import cn.com.entity.Admin;
import cn.com.entity.News;
import cn.com.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/news")
@ResponseBody
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * 查看所有公告信息
     * @return
     */
    @RequestMapping("/selAll")
    public List selAll(){
        List<News> list = newsService.selAll();
        return list;
    }

    /**
     * 发布公告信息
     * @param news
     * @return
     */
    @RequestMapping("/insertInfo")
    public Map insertInfo(@RequestBody News news, HttpSession session){
        Map<String, Object> map = new HashMap<>();
        //获取登录员工信息
        news.setNewsName(((Admin)session.getAttribute("admin")).getAdminName());
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);
        news.setNewsTime(createdate);
        System.out.println("----"+news);
        if(newsService.interInfo(news)){
            map.put("msg","公告发布成功");
        }else {
            map.put("msg","公告发布失败");
        }
        return map;
    }

    /**
     * 根据id删除公告信息
     * @param newsId
     * @return
     */
    @RequestMapping("/deleteById")
    public Map deleteById(int newsId){
        Map<String, String> map = new HashMap<>();
        if(newsService.deleteById(newsId)){
            map.put("msg","删除成功");
        }else {
            map.put("msg","删除失败");
        }
        return map;
    }
}
