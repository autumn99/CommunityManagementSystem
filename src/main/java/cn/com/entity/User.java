package cn.com.entity;

import java.io.Serializable;

public class User implements Serializable {

    private int userId;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userAddress;
    private String userHouse;
    private String userNumber;
    private String userStyle;
    private int userState;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserHouse() {
        return userHouse;
    }

    public void setUserHouse(String userHouse) {
        this.userHouse = userHouse;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserStyle() {
        return userStyle;
    }

    public void setUserStyle(String userStyle) {
        this.userStyle = userStyle;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userHouse='" + userHouse + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", userStyle='" + userStyle + '\'' +
                ", userState=" + userState +
                '}';
    }
}
