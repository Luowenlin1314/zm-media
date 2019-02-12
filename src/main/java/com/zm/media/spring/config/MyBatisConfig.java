package com.zm.media.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.zm.media.core.feature.orm.dialect.MySql5Dialect;
import com.zm.media.core.feature.orm.mybatis.PaginationResultSetHandlerInterceptor;
import com.zm.media.core.feature.orm.mybatis.PaginationStatementHandlerInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;


@Configuration
@Order(9)
@EnableTransactionManagement//启用事务注解
@MapperScan("com.zm.media.**.persistence")
@AutoConfigureAfter({DruidDataSourceConfig.class})
public class MyBatisConfig extends DataSourceTransactionManagerAutoConfiguration {

    @Autowired
    @Qualifier("mainDataSource")
    private DruidDataSource dataSource;

    /**
     * session工厂
     *
     * @return SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.zm.media.ibs");

        //添加数据库方言
        Properties properties = new Properties();
        properties.setProperty("dialectClass", MySql5Dialect.class.getName());
        bean.setConfigurationProperties(properties);

        //添加插件
        bean.setPlugins(new Interceptor[]{new PaginationResultSetHandlerInterceptor(), new PaginationStatementHandlerInterceptor()});

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:/com/zm/media/**/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * sqlSession模板
     *
     * @param sqlSessionFactory session工厂
     * @return SqlSessionTemplate
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 开启事务
     *
     * @return PlatformTransactionManager
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}