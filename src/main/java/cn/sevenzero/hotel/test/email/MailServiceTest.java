package cn.sevenzero.hotel.test.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @作者: 26706
 * @创建日期: 2018/9/26 16:57
 * @功能描述:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService MailService;

    @Test
    public void testSimpleMail() throws Exception {
        for (int i=0;i<999;++i){
            Thread.sleep(500);
            MailService.sendSimpleMail("954891923@qq.com","wang die is sb","i love you da sha bi."+new Date());
        }
    }
}
