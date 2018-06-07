package cn.hfbin.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* Spring boot 默认支持两种技术和ES交互
* 	1、Jest                       （org.springframework.boot.autoconfigure.elasticsearch.jest）
* 		默认不生效，需要导入依赖包
* 	2、SpringData ElasticSearch 	  （org.springframework.boot.autoconfigure.data.elasticsearch）
* 		1）、如果使用需要配置 Client节点信息 clusterName clusterNodes
* 		2）、提供了ElasticSearchTemplate工具 来操作ES
* 		3）、可以编写一个ElasticsearchRepository的子接口来操作ES
* */
@SpringBootApplication
public class SpringBootElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticsearchApplication.class, args);
	}
}
