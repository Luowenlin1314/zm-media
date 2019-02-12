package com.zm.media.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class DruidDataSourceConfig {

    @Value("${datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean
    public FilterRegistrationBean druidFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("sessionStatEnable","false");//关闭session监控
        return filterRegistrationBean;
    }

    /**
     * 配置写数据源 jpa注入
     */
    @Bean(name = "mainDataSource")
    @Primary
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource mainDataSource() throws Exception {
        return (DruidDataSource) DataSourceBuilder.create().type(dataSourceType).build();
    }
}