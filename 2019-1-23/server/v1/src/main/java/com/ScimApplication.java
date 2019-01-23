package com;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;

/**
 * 在启动类中添加对mapper包扫描@MapperScan
 * @MapperScan("com.example.loan.user.mapper")
springboot会自动加载spring.datasource.*相关配置，数据源就会自动注入到sqlSessionFactory中，sqlSessionFactory会自动注入到Mapper中
* <p>Title: MybatisDemoApplication</p>  

* <p>Description: </p>  

* @author xujianming  

* @date 2018年10月24日
 */


@EnableDiscoveryClient
@SpringBootApplication
public class ScimApplication {

	public static void main(String[] args) {
		System.out.println("-----Scim工程-------SpringBoot开始启动------------------");
		SpringApplication.run(ScimApplication.class, args);
		System.out.println("-----Scim工程-------SpringBoot启动完成------------------");
	}
	
	/**
	 * //配置mybatis的分页插件pageHelper
	
	 * <p>Title: pageHelper</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","oracle");    //配置postgresql数据库的方言支持Oracle,Mysql,MariaDB,SQLite,Hsqldb,PostgreSQL六种数据库
        pageHelper.setProperties(properties);
        return pageHelper;
    }
	 
} 
