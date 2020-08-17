package cn.com.entity;
import	java.io.Serializable;

public class Security implements Serializable {

    private int securityId;
    private String securityTitle;
    private String securityContents;

    public int getSecurityId() {
        return securityId;
    }

    public void setSecurityId(int securityId) {
        this.securityId = securityId;
    }

    public String getSecurityTitle() {
        return securityTitle;
    }

    public void setSecurityTitle(String securityTitle) {
        this.securityTitle = securityTitle;
    }

    public String getSecurityContents() {
        return securityContents;
    }

    public void setSecurityContents(String securityContents) {
        this.securityContents = securityContents;
    }

    @Override
    public String toString() {
        return "Security{" +
                "securityId=" + securityId +
                ", securityTitle='" + securityTitle + '\'' +
                ", securityContents='" + securityContents + '\'' +
                '}';
    }
}
