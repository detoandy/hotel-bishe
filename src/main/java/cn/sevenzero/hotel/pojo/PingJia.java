package cn.sevenzero.hotel.pojo;

import java.io.Serializable;

/**
 * 评价
 */
public class PingJia implements Serializable {
    private Integer id;
    private String msg;
    private String name;
    private String adddate;
    // private Integer jid;
    private JiuDian jiuDian;

    public JiuDian getJiuDian() {
        return jiuDian;
    }

    public void setJiuDian(JiuDian jiuDian) {
        this.jiuDian = jiuDian;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }

    @Override
    public String toString() {
        return "PingJia{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", name='" + name + '\'' +
                ", adddate='" + adddate + '\'' +
                ", jiuDian=" + jiuDian +
                '}';
    }
}
