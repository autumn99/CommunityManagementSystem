package cn.com.entity;

import java.io.Serializable;

public class News implements Serializable {

    private int newsId;
    private String newsTitle;
    private String newsContents;
    private String newsTime;
    private String newsName;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContents() {
        return newsContents;
    }

    public void setNewsContents(String newsContents) {
        this.newsContents = newsContents;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContents='" + newsContents + '\'' +
                ", newsTime='" + newsTime + '\'' +
                ", newsName='" + newsName + '\'' +
                '}';
    }
}
