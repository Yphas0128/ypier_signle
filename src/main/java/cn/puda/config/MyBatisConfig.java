package cn.puda.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @title: MyBatisConfig
 * @Author Ypier
 * @Date: 2021/4/6 9:01
 */
@Configuration
@EnableTransactionManagement
@MapperScan("cn.puda.mapper")
public class MyBatisConfig {

}
