package cn.sevenzero.hotel.pojo;

import java.io.Serializable;
import java.security.KeyStore;

/**
 * 新闻实体
 */
public class News implements Serializable{
  private Integer id;
  private String title;
  private String date;
  private String info;
  private String appuser;
  private String pic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", info='" + info + '\'' +
                ", appuser='" + appuser + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
