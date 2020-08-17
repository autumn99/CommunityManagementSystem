package cn.com.service;

import cn.com.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 查看所有用户信息
     * @return
     */
    List<User> selAll();

    /**
     * 根据姓名查询用户信息
     *
     * @param userName
     * @return
     */
    User selByName(String userName);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    Boolean insertInfo(User user);

    /**
     * 根据用户姓名更改用户电话信息
     * @param user
     * @return
     */
    Boolean updatePhone(User user);

    /**
     * 根据用户姓名更改用户状态
     * @param user
     * @return
     */
    Boolean updateState(User user);

    /**
     * 根据用户姓名修改用户密码
     * @param user
     * @return
     */
    Boolean updatePassword(User user);

    /**
     * 用户状态为1用户
     * @return
     */
    List<User> selState();

    /**
     * 根据用户姓名更改用户房产证号
     * @param user
     * @return
     */
    Boolean updateNumber(User user);

    /**
     * 根据电话查询用户
     * @param userName
     * @return
     */
    User selByPhone(String userPhone);
}
