package cn.com.entity;
import	java.io.Serializable;

public class Car implements Serializable {

    private int carId;
    private int carNumber;
    private String carNews;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarNews() {
        return carNews;
    }

    public void setCarNews(String carNews) {
        this.carNews = carNews;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carNumber=" + carNumber +
                ", carNews='" + carNews + '\'' +
                '}';
    }
}
