package cn.sevenzero.hotel.utils;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/4 14:52
 * @功能描述: 对用户的接口名称进行合法校验
 */
public class Verification {
    /**
     * 合法url
     *    user/login
     *    user/123456
     *    user
     *    123456
     *  其它的都是非法url
     */
    public static final String REGEX="([a-z|A-Z]+/[a-z|A-Z]+)|" +
            "([a-z|A-Z]+/[0-9]+)|" +
            "([a-z|A-Z]+)|" +
            "([0-9]+)";

    /**
     *  url 合法性校验
     * @param url 用户传个服务器的接口名称
     * @return 返回一个布尔值 true为合法 false为不合法
     */
    public static boolean urlCheck(String url){
        boolean result=false;
        url=url.trim();
        if(!"".equals(url)){
          result=url.matches(REGEX);
        }
        return result;
    }
}
