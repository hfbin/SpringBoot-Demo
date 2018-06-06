package cn.hfbin.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* 自动配置
* 	1、RabbitAutoConfiguration
* 	2、有了自动连接工厂 ConnectionFactory
* 	3、RabbitProperties 配置了RabbitMQ配置
* 	4、提供了 RabbitTemplate ：给rabbitmq	发送和接收消息
* 	5、AmqpAdmin ： 提供RabbitMQ系统功能组件
* 		AmqpAdmin提供了 Queue、Exchange、Binding
*
* 使用：
* 	1、在启动springboot容器中加入@EnableRabbit注解
* 		在需要处理的service方法上加上 @RabbitListener 进行监听消息队列内容
*
* */
@EnableRabbit
@SpringBootApplication
public class SpringBootAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAmqpApplication.class, args);
	}
}
