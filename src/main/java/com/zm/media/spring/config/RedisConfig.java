package com.zm.media.spring.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.zm.media.core.redis.RedisObjectSerializer;
import com.zm.media.spring.data.RedisProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;


import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collection;

/**
 * redis 配置类
 *
 * @author hejunlin
 * @version 1.0
 */
@Slf4j
@Configuration
public class RedisConfig {

    @Autowired
    private RedisProps redisProps;

    /**
     * redis连接工厂
     */
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(redisProps.getPool().getMaxIdle());
        config.setMaxTotal(redisProps.getPool().getMaxTotal());
        config.setMaxWaitMillis(redisProps.getPool().getMaxWaitMillis());
        config.setTestOnBorrow(redisProps.getPool().isTestOnBorrow());
        config.setTestOnReturn(redisProps.getPool().isTestOnReturn());
        config.setNumTestsPerEvictionRun(redisProps.getPool().getNumTestsPerEvictionRun());
        config.setTimeBetweenEvictionRunsMillis(redisProps.getPool().getTimeBetweenEvictionRunsMillis());
        config.setMinEvictableIdleTimeMillis(redisProps.getPool().getMinEvictableIdleTimeMillis());
        config.setSoftMinEvictableIdleTimeMillis(redisProps.getPool().getSoftMinEvictableIdleTimeMillis());
        config.setTestWhileIdle(redisProps.getPool().isTestWhileIdle());
        config.setBlockWhenExhausted(redisProps.getPool().isBlockWhenExhausted());

        JedisConnectionFactory factory = new JedisConnectionFactory(config);
        factory.setHostName(redisProps.getHost());
        factory.setPort(redisProps.getPort());
        factory.setPassword(redisProps.getPassword());
        factory.setTimeout(redisProps.getTimeout());
        factory.setDatabase(redisProps.getDatabase());
//        factory.setPoolConfig(new JedisPoolConfig());
        return factory;
    }


    /**
     * redis模板，用于获取redis操作对象
     */
    @Bean
    public StringRedisTemplate redisTemplate() {

        StringRedisTemplate template = new StringRedisTemplate();

        template.setConnectionFactory(redisConnectionFactory());
//        template.setValueSerializer(new JdkSerializationRedisSerializer());

        //Jackson序列化节省redis内存
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }

    /**
     * redis消息订阅（客户端）
     * 当redis重连订阅不会丢失
     * 发送订阅方法方法：
     * template.getConnectionFactory().getConnection().publish("user:topic".getBytes(), "hello".getBytes());
     *
     * @throws UnknownHostException
     */
    @Bean(name = "myMessageContainer")
    public RedisMessageListenerContainer messageContainer() throws UnknownHostException, SocketException {

        RedisMessageListenerContainer redisMsgContainer = new RedisMessageListenerContainer();

        log.debug("redis消息订阅（客户端）启动完成");
        redisMsgContainer.setConnectionFactory(redisConnectionFactory());

        redisMsgContainer.setErrorHandler(throwable -> log.error("redis订阅错误：", throwable));

        return redisMsgContainer;
    }
}
