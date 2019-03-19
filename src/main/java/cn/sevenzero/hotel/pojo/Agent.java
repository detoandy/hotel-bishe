package cn.sevenzero.hotel.pojo;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/14 10:27
 * @功能描述: 酒店代理商实体
 */
public class Agent {
    private Integer id;
    private String name;
    private String pwd;
    private String sex;
    private String position;// 职位
    private String tel;
    private String cpname; // 公司名称
    private String address;
    private int state; //状态
    private int rid;// 角色id

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCpname() {
        return cpname;
    }

    public void setCpname(String cpname) {
        this.cpname = cpname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", position='" + position + '\'' +
                ", tel='" + tel + '\'' +
                ", cpname='" + cpname + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", rid=" + rid +
                '}';
    }
}
