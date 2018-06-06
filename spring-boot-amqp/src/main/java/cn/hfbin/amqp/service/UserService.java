package cn.hfbin.amqp.service;

import cn.hfbin.amqp.bean.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by: HuangFuBin
 * Date: 2018/6/6
 * Time: 16:19
 * Such description:
 */

@Service
public class UserService {

    @RabbitListener(queues = "hfbin.news")
    public void massage(User user){
        System.out.println("收到消息："+user);
    }

    //自定义消息头
    @RabbitListener(queues = "hfbin")
    public void massage01(Message message){
        System.out.println(message);
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());

    }

}
