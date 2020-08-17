package cn.com.entity;
import	java.io.Serializable;

public class Visitor implements Serializable {

    private int visitorId;
    private String visitorName;
    private String visitorPhone;
    private String visitorTime;

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorPhone() {
        return visitorPhone;
    }

    public void setVisitorPhone(String visitorPhone) {
        this.visitorPhone = visitorPhone;
    }

    public String getVisitorTime() {
        return visitorTime;
    }

    public void setVisitorTime(String visitorTime) {
        this.visitorTime = visitorTime;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorId=" + visitorId +
                ", visitorName='" + visitorName + '\'' +
                ", visitorPhone='" + visitorPhone + '\'' +
                ", visitorTime='" + visitorTime + '\'' +
                '}';
    }
}
