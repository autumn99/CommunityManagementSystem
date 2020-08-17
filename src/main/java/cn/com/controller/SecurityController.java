package cn.com.controller;
import java.util.HashMap;
import	java.util.List;
import java.util.Map;

import cn.com.entity.Security;
import cn.com.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/security")
@ResponseBody
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    /**
     * 查询所有安防信息
     * @return
     */
    @RequestMapping("/getSecurity")
    public List getSecurity(){
        List<Security> list = securityService.selAll();
        return list;
    }

    /**
     * 删除安防信息
     * @param securityId
     * @return
     */
    @RequestMapping("/deleteInfo")
    public Map deleteInfo(int securityId){
        Map<String, Object> map = new HashMap<String, Object>();
        if (securityService.deleteInfo(securityId)){
            map.put("msg","删除成功");
        }else {
            map.put("msg","删除失败");
        }
        return  map;
    }

    /**
     * 添加访客信息
     * @param security
     * @return
     */
    @RequestMapping("/insertInfo")
    public Map insertInfo(@RequestBody Security security){
        Map<String, Object> map = new HashMap<String, Object> ();

        if(security.getSecurityTitle()=="" || security.getSecurityContents()==""){
            map.put("msg","主题或内容不能为空");
        }else {
            if (securityService.insertInfo(security)){
                map.put("msg","添加成功");
            }else {
                map.put("msg","添加失败");
            }
        }

        return  map;
    }
}
