package cn.sevenzero.hotel.pojo;

import java.io.Serializable;

/**
 * 客房
 */
public class KeFang implements Serializable {
    private Integer id;
    // private Integer jId; //外键
    private String name;
    private String chuang;
    private String ren;    // 房间人数
    private String price; // 房间价格
    private String type;
    private String state;
    //一对多映射 代表多的一端 多个客房对应一个酒店
    private JiuDian jiuDian;

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

    public String getChuang() {
        return chuang;
    }

    public void setChuang(String chuang) {
        this.chuang = chuang;
    }

    public String getRen() {
        return ren;
    }

    public void setRen(String ren) {
        this.ren = ren;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public JiuDian getJiuDian() {
        return jiuDian;
    }

    public void setJiuDian(JiuDian jiuDian) {
        this.jiuDian = jiuDian;
    }

    @Override
    public String toString() {
        return "KeFang{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chuang='" + chuang + '\'' +
                ", ren='" + ren + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                ", jiuDian=" + jiuDian +
                '}';
    }
}
