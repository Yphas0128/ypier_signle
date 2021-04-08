package cn.puda.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * @title: DataSourceConfig
 * @Author Ypier
 * @Date: 2021/4/6 8:52
 */
@Configuration
public class DataSourceConfig {

    /**
     * 配置 druid
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return  new DruidDataSource();
    }
    // 是否需要配置 druid 后端监视器


}
