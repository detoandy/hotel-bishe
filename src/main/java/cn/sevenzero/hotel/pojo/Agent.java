package cn.sevenzero.hotel.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 */
public class Agent {
    private Integer id;
    private String name;
    private String pwd;
    private String tel;
    private int state; //状态
    private int rid;// 角色id
    private String email;
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date updateTime;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", tel='" + tel + '\'' +
                ", state=" + state +
                ", rid=" + rid +
                '}';
    }
}
