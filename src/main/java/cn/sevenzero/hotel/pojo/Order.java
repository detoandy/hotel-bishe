package cn.sevenzero.hotel.pojo;

import java.io.Serializable;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/13 17:27
 * @功能描述: 用户订单实体
 */
public class Order implements Serializable{
  private Integer oId;// 订单编号
  private String userTel;// 用户手机
  private String occupantName;// 入户人姓名
  private String paymentState;// 支付转态
  private String startDate;// 入住日期
  private String expiryDate;// 离开时间
  private String hotelName;// 酒店名称
  private double paymentAmount; //支付金额
  private String roomType;// 房间类型
  private int roomCount;// 房间数量
  private String userPhone;// 用户手机号

  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  public Integer getoId() {
    return oId;
  }

  public void setoId(Integer oId) {
    this.oId = oId;
  }

  public String getUserTel() {
    return userTel;
  }

  public void setUserTel(String userTel) {
    this.userTel = userTel;
  }

  public String getOccupantName() {
    return occupantName;
  }

  public void setOccupantName(String occupantName) {
    this.occupantName = occupantName;
  }

  public String getPaymentState() {
    return paymentState;
  }

  public void setPaymentState(String paymentState) {
    this.paymentState = paymentState;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public String getHotelName() {
    return hotelName;
  }

  public void setHotelName(String hotelName) {
    this.hotelName = hotelName;
  }

  public double getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(double paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public int getRoomCount() {
    return roomCount;
  }

  public void setRoomCount(int roomCount) {
    this.roomCount = roomCount;
  }

  @Override
  public String toString() {
    return "Order{" +
            "oId=" + oId +
            ", userTel='" + userTel + '\'' +
            ", occupantName='" + occupantName + '\'' +
            ", paymentState='" + paymentState + '\'' +
            ", startDate='" + startDate + '\'' +
            ", hotelName='" + hotelName + '\'' +
            ", paymentAmount=" + paymentAmount +
            ", roomType='" + roomType + '\'' +
            ", roomCount=" + roomCount +
            '}';
  }
}
