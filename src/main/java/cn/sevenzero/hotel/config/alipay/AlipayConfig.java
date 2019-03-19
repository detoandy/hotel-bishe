package cn.sevenzero.hotel.config.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016081600258339";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCEVqgbzwQncTmBKQlqkJiQcQvemYpjqL1ekvIY39Nbd15H3G2PIDTAIA1u7ykI+qLwRsM1Ss4nbv9Q1eCnQBEeIWQpioteN5Z89ZFmawS06ZhLa9anlNeg1hNRITlVuEeXgzJwG4yDpjb7ye4Q/+uctcel+S+MqLrb7IWWB5F0tphrg3uk30tQOLXRTsBPRsw/8gaTWuKc7GlkVHPpax6YrlWTHDEw9H0Gssludcd1q1+vGqNmWv1YaK3GPODZ+eOeRvd6sm6JRSihRxEy5sokyitnvfKe06KoZlp95js4faYUCfsh7tqhX0UHXwei+6D+jMAEKOP8sFC3kIZECSjhAgMBAAECggEAG7Ts402XSA67hGAsGYSGfI8+de9devoEE73eM/kAjkDSm2b6BSIwCR1s0pH93GRlIrsd+ZVczgK+L5VnwHx4WP+SsePQw/wNZMIhG/lB9gKGIRxFx7Yw4vqO9shm8ZxwWLdeIvyRkaqGDnc7gZGjKZ8hWo1uOBvHa238lemluXKF5W9ALmz+lroqsZEr9B9PA9TJR5FyMJ8FYD1g50xbS9TSOL8xjcpJA5namVhJYF/7/8zr6x8B/O4gIs1aALpC1GtH+DX9haz+CBxn7ankD/aJUxIlVLtwp9NRr6obRQ4g5izwmjvGDUry7VsMFCWF/0fxg+4CKJhCLUJkrK+aMQKBgQDqeGxA1SV9ergfe3rlKY+Ksy24umxCS5NXT+ZrKt8KRMwgilkgZpqfyf0Xyfq13t0CrQrBqy8ql8T/wC0JtDbWslb64CBJkVo8GI2KHGJHP2zl2amNgq8yV/ST4FntY6cT6659Y3brvf9Ufm3bmabeD5pngkyLUgA+u6qpOjPHpQKBgQCQfXiN+V26lako1tQIbHXXFl6sqIokK1auuTyDr1FaYhk1ZZNQuufVQPwajNM7EjNGYWdMK+uHAQsFykFhOv1AZ1reVQQvKWNKBmmPjqNgQGurgdAZ1D2QLSUVdmPH9ekZRRMHi5ndqoGv3LvI4v9Oqc2Oj31XLnoPmtSuWxT3jQKBgFKk96MyffBonRWbtImpyIqe9XKzYw1LDjgsVY9YoR1BeqHNofSltcK0s5z6+H+6ejRDQhNZf1qH/EwZNMbC2sF6QuZSsY68yQ19qgYQUyPB22R5ACZ89bvM/MxSu9/MzEtdOze/I1+crK7fkWFiG0sSPN5XMxu4X5W9GD5l4XJxAoGABJVmYKKbfZLH1frSqR2/sz4LbNC/6RvS2SIZMFg8bXCVOiNpw/LZ7eLs3G7BOKuAIuhuHXV7OEIpNlrPLiVv6T4eHNV3l4NpmeyQJrSwrBn/EGbC0j7wYQV9mquxyKMdbObLDr8391c0W/7Vmi7RSI6MbcxRfpWD28DepFVRWfUCgYEA1wISsNqquZeVJERIOObxt7LLa5AIa2Ewl3N7VPS6kh/pFEVfzIFnpDZvrm48vWKF2OMd+vMLWIN5auJUMtDBFknZ5uo+aiz+Bsb6V8c9Pt/XVhD7z3v3pRqKXS/Re+6sPvJyeOXEiRqArJPhE1YXdug9xhXSEAOy9ySeLP0cIeE=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsdXAy4GmFh18RqkB+eCUbsARaSaA/tNuxGou86cnuwG0PcaPLwUyiB+NSKft9r/enBizW/cSGXuo7WRAbi/fcRC1dEhBNa1fg/xZ8npqzApR809Q0BA1XyiTDaD/XHUysiKGcAofsBAUUhIADs6lm17Hka6SGWf+2ua6uap7aQGH+TtDatOA/GFvz8pJCe0Kvo3/V5tjerXziHciIWlEOGXEIcAkoosRhIjHP77rZOJTXgqjJy8ldghWnIl8wcfIDY3H5ua3OrEUdW627Cqs2gry4P5lz0oDX+p0PVFXkRF2lwZIHi0dnVdD5jqMKb2kKucw3KQrApSS529xfzfztQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:80/jdydxt/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://desktop-34s0m8s:8080/jdydxt/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关  
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}

