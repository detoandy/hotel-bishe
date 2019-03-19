package cn.sevenzero.hotel.test.email;

/**
 * @作者: 26706
 * @创建日期: 2018/9/26 16:56
 * @功能描述:
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);
}
