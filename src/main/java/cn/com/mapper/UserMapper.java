package cn.com.mapper;

import cn.com.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    /**
     * 查看所有用户信息
     * @return
     */
    @Select("select * from user")
    List<User> selAll();

    /**
     * 用户状态为1用户
     * @return
     */
    @Select("select * from user where userState=1")
    List<User> selState();

    /**
     * 根据姓名查询用户信息
     *
     * @param userName
     * @return
     */
    @Select("select * from user where userName=#{userName}")
    User selByName(String userName);

    /**
     * 根据电话查询用户
     * @param userPhone
     * @return
     */
    @Select("select * from user where userPhone=#{userPhone}")
    User selByPhone(String userPhone);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @Insert("insert into user (userName,userPassword,userPhone,userAddress,userHouse,userState,userNumber,userStyle) " +
            " values(#{userName},#{userPassword},#{userPhone},#{userAddress},#{userHouse},#{userState},#{userNumber},#{userStyle})")
    Boolean insertInfo(User user);

    /**
     * 根据用户姓名更改用户电话信息
     * @param user
     * @return
     */
    @Update("update user set userPhone =#{userPhone} where userName=#{userName}")
    Boolean updatePhone(User user);

    /**
     * 根据用户姓名更改用户房产证号
     * @param user
     * @return
     */
    @Update("update user set userNumber =#{userNumber} where userName=#{userName}")
    Boolean updateNumber(User user);


    /**
     * 根据用户姓名修改用户密码
     * @param user
     * @return
     */
    @Update("update user set userPassword=#{userPassword} where userName=#{userName}")
    Boolean updatePassword(User user);

    /**
     * 根据用户姓名更改用户状态
     * @param user
     * @return
     */
    @Update("update user set userState =#{userState} where userName=#{userName}")
    Boolean updateState(User user);


}
