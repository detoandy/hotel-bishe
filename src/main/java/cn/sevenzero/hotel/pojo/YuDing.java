package cn.sevenzero.hotel.pojo;

import java.io.Serializable;

/**
 * 用户预定实体
 */
public class YuDing implements Serializable {
    private Integer id;
    private String name;
    private String fang;
    private String count;
    private String bdate;
    private String edate;
    private String tel;
    private String fangkuan;
    private String ism;
    private String mtel;
    private String tradeno;// 订单号
    private String state;//支付状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFang() {
        return fang;
    }

    public void setFang(String fang) {
        this.fang = fang;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFangkuan() {
        return fangkuan;
    }

    public void setFangkuan(String fangkuan) {
        this.fangkuan = fangkuan;
    }

    public String getIsm() {
        return ism;
    }

    public void setIsm(String ism) {
        this.ism = ism;
    }

    public String getMtel() {
        return mtel;
    }

    public void setMtel(String mtel) {
        this.mtel = mtel;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
