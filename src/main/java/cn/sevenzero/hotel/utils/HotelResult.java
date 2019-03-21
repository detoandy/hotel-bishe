package cn.sevenzero.hotel.utils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 */

public class HotelResult implements Serializable {
    // 响应业务状态
    private Integer status;
    // 响应消息
    private String msg;
    // 响应中的数据
    private Object data;

    private int totalPage;// 总页数
    private int currentPage;// 当前页面
    private int totalSize;// 总共记录数
    private int pageSize;// 设置一页多少条记录
    private Object conditionPoJo;// 查询条件pojo

    /**
     * 设置页数 设置页数会顺带着把总页数算出来
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        setTotalPage(pageSize);
    }

    /**
     * 根据每页显示的数据设置求总共页数
     * @param pageSize 一页要显示的记录数
     */
    private void setTotalPage(int pageSize) {
        // 计算总页数
        int page=this.totalSize/pageSize;// 总页数
        if(this.totalSize%pageSize!=0){// 有多余的加一页
            page+=1;
        }else if(page==0){ //说明设置的页数比记录数还多
            page=1;
        }
        this.totalPage=page;// 设置页数
    }


    public Object getConditionPoJo() {
        return conditionPoJo;
    }

    public void setConditionPoJo(Object conditionPoJo) {
        this.conditionPoJo = conditionPoJo;
    }

    public int getTotalPage() {
        return totalPage;
    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getPageSize() {
        return pageSize;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 用来把json转换成实体类
     *
     * @param json  json 字符串
     * @param clazz 封装json的实体
     * @return 返回封装了json的实体
     */
    public static <T> T strToObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 把实体类转换成json
     *
     * @param object 需要被转换实体
     * @return 返回被转换的json串
     */
    public static String objToJson(Object object) {
        return JSON.toJSONString(object);
    }

    public static HotelResult build(Integer status, String msg, Object data) {
        return new HotelResult(status, msg, data);
    }

    /**
     * 响应成功转态(有数据)
     * @param data 返回的数据
     * @return
     */
    public static HotelResult ok(Object data) {
        return new HotelResult(data);
    }

    /**
     *  响应成功转态(无数据)
     * @return
     */
    public static HotelResult ok() {
        return new HotelResult(null);
    }
    /**
     * 用来构建错误信息
     * @param status
     * @param msg
     * @return
     */
    public static HotelResult build(Integer status, String msg) {
        return new HotelResult(status, msg, null);
    }

    /**
     * 保存3个转态
     * @param status
     * @param msg
     * @param data
     */
    public HotelResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 初始化转态
     * @param data
     */
    public HotelResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    /**
     * 无参构造函数
     */
    public HotelResult() {

    }

    @Override
    public String toString() {
        return "HotelResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", totalSize=" + totalSize +
                ", pageSize=" + pageSize +
                ", conditionPoJo=" + conditionPoJo +
                '}';
    }
}
