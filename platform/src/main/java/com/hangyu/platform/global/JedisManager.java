package com.hangyu.platform.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis客户端连接
 */
public class JedisManager {

  private static final Logger logger = LoggerFactory.getLogger(JedisManager.class);
  private static final String REDIS_HOST = "localhost";
  private static final Integer REDIS_PORT = 6379;
  private static JedisPool jedisPool;
  private static Jedis jedis;
  private static JedisPoolConfig config = new JedisPoolConfig();

  private static void init(){
    config.setMaxTotal(1000);
    config.setMaxIdle(10);
    config.setMaxWaitMillis(10*1000);
    config.setTestOnBorrow(true);//borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    config.setTestOnReturn(true);//return一个jedis实例给pool时，是否检查连接可用,设置为true时，返回的对象如果验证失败，将会被销毁，否则返回
  }

  public static Jedis getJedisPool(){
    if(null == jedis){
      synchronized (JedisPool.class){
        if(null == jedis){
          init();
          jedisPool = new JedisPool(config, REDIS_HOST, REDIS_PORT, 3000);
          logger.info("【Redis lock】jedisPool初始化成功......");
          Jedis jedis = jedisPool.getResource();
          return jedis;
        }
      }
    }
    return jedis;
  }

}
