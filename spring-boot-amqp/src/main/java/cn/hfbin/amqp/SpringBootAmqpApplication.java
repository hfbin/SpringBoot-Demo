package cn.hfbin.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* 自动配置
* 	1、RabbitAutoConfiguration
* 	2、有了自动连接工厂 ConnectionFactory
* 	3、RabbitProperties 配置了RabbitMQ配置
* 	4、提供了 RabbitTemplate ：给rabbitmq	发送和接收消息
* 	5、AmqpAdmin ： 提供RabbitMQ系统功能组件
* */
@SpringBootApplication
public class SpringBootAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAmqpApplication.class, args);
	}
}
