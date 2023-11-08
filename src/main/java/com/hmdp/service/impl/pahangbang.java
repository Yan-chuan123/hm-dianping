package com.hmdp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pahangbang {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void addPlayerScore(String player, int score) {
        redisTemplate.opsForValue().set(player, Integer.toString(score));
    }

    public void updatePlayerScore(String player, int score) {
        redisTemplate.opsForValue().set(player, Integer.toString(score - getPlayerScore(player)));
    }

    public int getPlayerScore(String player) {
        return Integer.parseInt(redisTemplate.opsForValue().get(player));
    }

//    public List<String> getLeaderboard() {
//        // 使用有序集合的ZREVRANGE方法获取排行榜前N名玩家
//        // N为排行榜大小，你可以根据实际需求设置
////        return redisTemplate.opsForZSet().reverseRange(0, 5);
//    }
}