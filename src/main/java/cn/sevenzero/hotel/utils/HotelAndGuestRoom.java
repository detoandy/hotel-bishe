package cn.sevenzero.hotel.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/11 11:10
 * @功能描述: 封装酒店查询条件
 */
public class HotelAndGuestRoom {

    private final Logger logger= LoggerFactory.getLogger(HotelAndGuestRoom.class);
    private String name; // 酒店名字
    private String dizhi;// 酒店位置
    private String price;// 酒店房间价格
    private String ren;// 酒店房间人数
    private String style;// 酒店级别
    // 解析查询条件字段
    private String roomPrice;
    private String between;
    private String and;
    private String numberOfpeople;
    public boolean roomPriceMark0=false,roomPriceMark1=false,roomPriceMark2=false;
    public boolean numberOfPeopleMark0=false,numberOfPeopleMark1=false;

    // 第n 页数据
    private int pageNo;

    public void setPageNo(int pageNo) {
       this.pageNo=pageNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    /**
     * 解析房价的查询条件
     * @param roomPrice
     */
    public void parseRoomPrice(String roomPrice){
        if("arbitrarily".equals(roomPrice)){
             // 设置 为不限标记
            this.roomPriceMark0=true;
        }else{
            if(roomPrice.contains("+")){ // 设置价格+ 标记
                this.roomPrice= roomPrice.substring(0,roomPrice.length());
                roomPriceMark1=true;
            }else if(roomPrice.contains("-")){ // 设置 区间价格 标记
                String[]strArr=roomPrice.split("-");
                between=strArr[0];
                and=strArr[1];
                this.roomPriceMark2=true;
            }else if(roomPrice.matches("[0-9]+")){ // 默认 单数字
                this.roomPrice=roomPrice;
            }
        }
    }

    // 解析住房人数条件
    public void parseNumberOfPeople(String numberStr){
        if(numberStr.equals("arbitrarily")){
            this.numberOfPeopleMark0=true;
        }else{
            if(numberStr.contains("+")){
                this.numberOfpeople=numberStr.substring(0,numberStr.length());
                this.numberOfPeopleMark1=true;
            }else{
                numberOfpeople=numberStr.substring(0,numberStr.length());
            }
       }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRen() {
        return ren;
    }

    public void setRen(String ren) {
        this.ren = ren;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "HotelAndGuestRoom{" +
                "name='" + name + '\'' +
                ", dizhi='" + dizhi + '\'' +
                ", price='" + price + '\'' +
                ", ren='" + ren + '\'' +
                ", style='" + style + '\'' +
                ", roomPrice='" + roomPrice + '\'' +
                ", between='" + between + '\'' +
                ", and='" + and + '\'' +
                ", numberOfpeople='" + numberOfpeople + '\'' +
                ", roomPriceMark0=" + roomPriceMark0 +
                ", roomPriceMark1=" + roomPriceMark1 +
                ", roomPriceMark2=" + roomPriceMark2 +
                ", numberOfPeopleMark0=" + numberOfPeopleMark0 +
                ", numberOfPeopleMark1=" + numberOfPeopleMark1 +
                ", pageNo=" + pageNo +
                '}';
    }
}