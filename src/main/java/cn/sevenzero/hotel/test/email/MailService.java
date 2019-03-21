package cn.sevenzero.hotel.test.email;

/**
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);
}
