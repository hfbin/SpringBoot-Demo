package cn.hfbin.amqp;

import cn.hfbin.amqp.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
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

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	public void creartSxchange(){

		/**
		 * Exchange交换器，用来接收生产者发送的消息并将这些消息路由给服务器中的队列。
		 * Exchange有4种类型：direct(默认)，fanout, topic, 和headers，不同类型的Exchange转发消息的策略有所区别
		 *   1、new FanoutExchange()
		 *   2、new DirectExchange()
		 *   3、new TopicExchange()
		 *   4、new HeadersExchange()
		 */

		amqpAdmin.declareExchange(new FanoutExchange("amqpadmin.FanoutExchange" ));

		amqpAdmin.declareQueue(new Queue("FanoutExchange.queue1" , true) );

		amqpAdmin.declareBinding(new Binding("FanoutExchange.queue1" ,Binding.DestinationType.QUEUE ,
				"amqpadmin.FanoutExchange","FanoutExchange.queue1" , null));
	}

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
		User user = new User();
		user.setId(1);
		user.setUsername("hfbin");
		user.setAge(15);

		rabbitTemplate.convertAndSend("amqpadmin.exchange1", "amqp.haha1" , user);
	}

	@Test
	public void receive(){
		Object o = rabbitTemplate.receiveAndConvert("amqpadmin.queue1");
		System.out.println(o.getClass());
		System.out.println(o);

	}

	/**
	 * 广播
	 *
	 */
	@Test
	public void sendMag() {
		/**
		 * object默认当成消息体，只需要传入发送的对象自动序列化发送给rabbitmq
		 *  @exchange 交换器
		 *  @routekey 路由件
		 *  @object 信息
		 */
		User user = new User();
		user.setId(1);
		user.setUsername("hfbin");
		user.setAge(15);

		rabbitTemplate.convertAndSend("exchange.fanout", "" , user);
	}

}
