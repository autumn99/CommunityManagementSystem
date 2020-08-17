package cn.com.controller;
import	java.util.ArrayList;
import	java.util.List;
import	java.util.HashMap;

import cn.com.entity.User;
import cn.com.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@ResponseBody
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录验证
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public Map login(@RequestBody User user,HttpSession session){
        Map<String, Object> map = new HashMap<String, Object> ();
        String password = new SimpleHash("MD5",user.getUserPassword(),user.getUserPassword(),1024).toHex();
        System.out.println(password);
        if(userService.selByPhone(user.getUserPhone()) == null){
            map.put("msg","用户名不存在");
        }else if (!userService.selByPhone(user.getUserPhone()).getUserPassword().equals(password)){
            map.put("msg","密码错误");
        }else if(userService.selByPhone(user.getUserPhone()).getUserPassword().equals(password)){
            map.put("msg","登录成功");
            //将user对象存进session
            session.setAttribute("user",userService.selByPhone(user.getUserPhone()));
        }
        return map;
    }

    /**
     * 注册账号
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public Map register(@RequestBody User user){
        Map<String, Object> map = new HashMap<String, Object> ();
        String password = new SimpleHash("MD5",user.getUserPassword(),user.getUserPassword(), 1024).toHex();
        user.setUserPassword(password);
        if (user.getUserName()==""){
            map.put("msg","用户姓名不能为空");

        }else {
                if(userService.insertInfo(user)){
                    map.put("msg","注册成功");
                }else {
                    map.put("msg","注册失败");
                }
            }
        return map;
    }

    /**
     * 获取登录用户信息
     * @param session
     * @return
     */
    @RequestMapping("getUser")
    public User getUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        return user;
    }

    /**
     * 查询当前数据库用户信息
     * @param userName
     * @return
     */
    @RequestMapping("nowUser")
    public User getUser(String userName){
        User user = userService.selByName(userName);
        return user;
    }

    /**
     * 退出登录
     * @param session
     * @param response
     * @throws Exception
     */
    @RequestMapping("/outLog")
    public void outLog(HttpSession session, HttpServletResponse response) throws Exception{
        session.removeAttribute("user");
        response.sendRedirect("../html/login.html");
    }

    /**
     * 修改电话信息
     * @param user
     * @return
     */
    @RequestMapping("/updatePhone")
    public Map updatePhone(@RequestBody User user){
        Map<String,String> map = new HashMap<String, String> ();
        if(userService.updatePhone(user)){
            map.put("msg","修改成功");
        }else {
            map.put("msg","修改失败");
        }
        return map;
    }

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    @RequestMapping("/updatePassword")
    public Map updatePassword(@RequestBody User user){
        Map<String,String> map = new HashMap<String, String> ();
        System.out.println(user.getUserPassword());

        user.setUserPhone((userService.selByName(user.getUserName()).getUserPhone()));
        if(user.getUserPassword()==""){
            map.put("msg","密码不为空");
        }else{
            String password = new SimpleHash("MD5",user.getUserPassword(),user.getUserPassword(), 1024).toHex();
            user.setUserPassword(password);
            if(userService.updatePassword(user)){
                map.put("msg","修改成功");
            }else {
                map.put("msg","修改失败");
            }
        }
        return map;
    }

    /**
     * 求助
     * @param userName
     * @return
     */
    @RequestMapping("/help")
    public Map help(String userName){
        Map<String,String> map = new HashMap<String, String> ();
        User user = userService.selByName(userName);
        int state = user.getUserState();
        user.setUserState(1);
        if(state != 0){
            map.put("msg","已发送求助信息，物业正前往处理");
        }else if(userService.updateState(user)){
            map.put("msg","求助成功，物业正前往处理");
        }else {
            map.put("msg","求助失败，请到物业前台咨询");
        }
        return map;
    }

    /**
     * 取消求助
     * @param userName
     * @return
     */
    @RequestMapping("/nohelp")
    public Map nohelp(String userName){
        Map<String,String> map = new HashMap<String, String> ();
        User user = userService.selByName(userName);
        int state = user.getUserState();
        user.setUserState(0);
        if(state != 1){
            map.put("msg","已取消求助，请勿重新点击");
        }else if(userService.updateState(user)){
            map.put("msg","取消成功，如再有问题请及时与物业联系");
        }else {
            map.put("msg","取消失败，请到物业前台咨询");
        }
        return map;
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @RequestMapping("/selUser")
    public List selUser() {
        List<User> list = userService.selAll();
        return list;
    }

    /**
     * 更新用户状态
     * @param user
     * @return
     */
    @RequestMapping("/updateState")
    public Map updateState(@RequestBody User user){
        Map<String,String> map = new HashMap<String, String> ();

        if(userService.updateState(user)) {
            map.put("msg", "成功");
        }else {
            map.put("msg","失败");
        }
        return map;
    }

    /**
     * 更该用户房产证号
     * @param user
     * @return
     */
    @RequestMapping("/updateNumber")
    public Map updateNumber(@RequestBody User user){
        Map<String,String> map = new HashMap<String, String> ();

        if(userService.updateNumber(user)) {
            map.put("msg", "成功");
        }else {
            map.put("msg","失败");
        }
        return map;
    }

    /**
     * 需要求助用户信息
     * @return
     */
    @RequestMapping("/selHelp")
    public List selHelp() {
        List<User> list = userService.selState();
        return list;
    }
}
