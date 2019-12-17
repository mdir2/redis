package me.wook.redis.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.wook.redis.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public String hello() {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();

        Message msg = Message.builder()
                .id("wook")
                .message("안녕하세요")
                .build();
        ops.set("msg", msg);
        return new Gson().toJson(ops.get("msg"));
    }
}
