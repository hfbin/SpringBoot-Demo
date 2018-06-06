package cn.hfbin.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAmqpApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	/**
	 * 单播 （点对点）
	 */
	@Test
	public void contextLoads() {


		/**
		 * object默认当成消息体，只需要传入发送的对象自动序列化发送给rabbitmq
		 *  @exchange 交换器
		 *  @routekey 路由件
		 *  @object 信息
		 */
		HashMap<String, Object> map = new HashMap<>();
		map.put("status" , "1");
		map.put("data" , Arrays.asList("username" , "email" , "age"));
		rabbitTemplate.convertAndSend("exchange.direct", "hfbin.emps" , map);
	}

}
