package cn.sevenzero.hotel.pojo;

import java.io.Serializable;

/**
 * 消息实体
 */
public class Message implements Serializable {
    private Integer id;
    private String msg;
    private String appuser;
    private String date;
    private String reply;

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

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", appuser='" + appuser + '\'' +
                ", date='" + date + '\'' +
                ", reply='" + reply + '\'' +
                '}';
    }
}
