package org.huha.bsresponsewrap.demo.config;

import org.huha.bsresponsewrap.demo.user.LoginToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author WangKun
 * @create 2019-01-03
 * @desc
 **/
@Configuration
public class RedisConfig {

    @Bean("loginTokenTemplate")
    public RedisTemplate<String, LoginToken> loginTokenTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, LoginToken> template = new RedisTemplate<String, LoginToken>();

        Jackson2JsonRedisSerializer<LoginToken> jsonRedisSerializer = new Jackson2JsonRedisSerializer<LoginToken>(LoginToken.class);
        template.setValueSerializer(jsonRedisSerializer);
        template.setHashValueSerializer(jsonRedisSerializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

}
