package cn.com.controller;
import	java.util.List;

import cn.com.entity.Admin;
import cn.com.service.AdminService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@ResponseBody
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 登录
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public Map selAll(@RequestBody Admin admin, HttpSession session){
        Map<String,String> map = new HashMap<>();
        String password = new SimpleHash("MD5",admin.getAdminPassword(),admin.getAdminName(),1024).toHex();
        System.out.println(password);
        if(adminService.selByName(admin.getAdminName()) == null){
            map.put("msg","用户名不存在");
        }else if (!adminService.selByName(admin.getAdminName()).getAdminPassword().equals(password)){
            map.put("msg","密码错误");
        }else if(adminService.selByName(admin.getAdminName()).getAdminPassword().equals(password)){
            map.put("msg","登录成功");
            //将user对象存进session
            session.setAttribute("admin",adminService.selByName(admin.getAdminName()));
        }
        return map;
    }

    /**
     * 获取登录admin信息
     * @param session
     * @return
     */
    @RequestMapping("/getAdmin")
    public Admin getAdmin(HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        return admin;
    }

    /**
     * 退出登录
     * @param session
     * @param response
     * @throws Exception
     */
    @RequestMapping("/logout")
    public void outLog(HttpSession session, HttpServletResponse response) throws Exception{
        session.removeAttribute("admin");
        response.sendRedirect("../html/adminLogin.html");
    }

    /**
     * 获取所有员工信息
     * @return
     */
    @RequestMapping("/selAll")
    public List selAll(){
        List<Admin> list = adminService.selAll();
        return list;
    }

    /**
     * 添加员工信息
     * @param admin
     * @return
     */
    @RequestMapping("/insertInfo")
    public Map insertInfo(@RequestBody Admin admin){
        Map<String, Object> map = new HashMap<String, Object> ();
        String password = new SimpleHash("MD5",admin.getAdminPassword(),admin.getAdminName(),1024).toHex();
        admin.setAdminPassword(password);
        if (admin.getAdminName()==""||admin.getAdminPassword()==""||admin.getAdminPhone()==""){
            map.put("msg","请填写全部信息");
        }if (admin.getAdminName().equals(adminService.selByName(admin.getAdminName()))){
            map.put("msg","用户名存在，请重新输入");
        } else {
            if (adminService.insertInfo(admin)){
                map.put("msg","添加成功");
            }else {
                map.put("msg","添加失败");
            }
        }
        return map;
    }

    /**
     * 删除员工信息
     * @param admin
     * @return
     */
    @RequestMapping("/deleteInfo")
    public Map deleteInfo(@RequestBody Admin admin){
        Map<String, Object> map = new HashMap<String, Object> ();
            if (adminService.delete(admin.getAdminId())){
                map.put("msg","删除成功");
            }else {
                map.put("msg","删除失败");
            }

        return map;
    }

    /**
     * 修改员工信息
     * @param admin
     * @return
     */
    @RequestMapping("/updtaeInfo")
    public Map updtaeInfo(@RequestBody Admin admin){
        Map<String, Object> map = new HashMap<String, Object> ();
        String password = new SimpleHash("MD5",admin.getAdminPassword(),admin.getAdminName(),1024).toHex();
        admin.setAdminPassword(password);
        System.out.println(admin);
        if (admin.getAdminPassword()==""||admin.getAdminPhone()==""){
            map.put("msg","请填写全部信息");
        }else {
            if (adminService.updateInfo(admin)){
                map.put("msg","修改成功");
            }else {
                map.put("msg","修改失败");
            }
        }
        return map;
    }
}
