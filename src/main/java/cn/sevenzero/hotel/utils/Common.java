package cn.sevenzero.hotel.utils;

import java.util.List;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/7 15:15
 * @功能描述: 保证各层的通用代码
 */
public class Common {
    /**
     * 包装service层的基本业务
     * @param list
     * @param msg
     * @return
     */
    public static HotelResult wrapService(List list, String msg){
        if(list!=null && list.size()>0){
            return HotelResult.ok(list);
        }else{
            return HotelResult.build(500,msg);
        }
    }

    public static HotelResult wrapService(Object obj,String msg){
       if(obj!=null){
           return HotelResult.ok(obj);
       }else{
           return HotelResult.build(500,msg);
       }
    }

    /**
     *
     * @param data 响应给客户的数据
     * @param condition 客户查询的条件
     * @param result 被返回的HotelResult
     * @param pageNo 查询的页码
     * @return
     */
    public static HotelResult wrapService(Object data, Object condition, HotelResult result, int pageNo){
        if(data!=null){
            result.setData(data);//保存查询数据
            if(data instanceof List){
                result.setConditionPoJo(condition);// 保存查询条件
                result.setCurrentPage(pageNo); // 保存当前页码
                result.setTotalSize(((List)data).size());//设置总记录数
                result.setPageSize(10);// 设置一页显示多少数据
            }
        }else{
            result.setMsg("数据为空!!!");
        }
        return result;
    }
}