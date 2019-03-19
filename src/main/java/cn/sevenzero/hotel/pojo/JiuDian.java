package cn.sevenzero.hotel.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

/**
 * 酒店实体
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class JiuDian implements Serializable {

    private Integer id;    // 唯一标识

    @NotEmpty(message = "酒店名不能为空")
    private String name;  // 酒店名字

    @NotEmpty(message = "地址不能为空")
    private String dizhi; // 地址

    @NotEmpty(message = "不能为空")
    private String style; // 酒店风格

    @NotEmpty(message = "不能为空")
    private String info; // 酒店信息

    //@NotEmpty(message = "不能为空")
    private String pic; // 酒店图片

    @Pattern(regexp = "(1[5|3|8|7][0-9]{9})")
    private String tel; // 电话

    private int aid;// 酒店管理员 外键
    // 一对多 映射 代表一个的一端 一个酒店的有多个客房
    private List<KeFang>guestroomList; // 客房

    private List<PingJia> evaluateList;//评价类表

    public List<PingJia> getEvaluateList() {
        return evaluateList;
    }

    public void setEvaluateList(List<PingJia> evaluateList) {
        this.evaluateList = evaluateList;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public List<KeFang> getGuestroomList() {
        return guestroomList;
    }

    public void setGuestroomList(List<KeFang> guestroomList) {
        this.guestroomList = guestroomList;
    }

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

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "JiuDian{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dizhi='" + dizhi + '\'' +
                ", style='" + style + '\'' +
                ", info='" + info + '\'' +
                ", pic='" + pic + '\'' +
                ", tel='" + tel + '\'' +
                ", aid=" + aid +
                ", guestroomList=" + guestroomList +
                ", evaluateList=" + evaluateList +
                '}';
    }

    public JiuDian() {
    }
}
