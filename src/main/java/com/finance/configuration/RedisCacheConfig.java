package com.finance.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("application.properties")
public class RedisCacheConfig {

	// Redis server host ip/domain name
	@Value("${redis.host}")
	private String redisHost;

	// Redis server port
	@Value("${redis.port}")
	private Integer redisPort;

	// Timeout value in seconds
	@Value("${redis.timeout}")
	private Integer redisTimeout;

	@Bean
	public JedisPool jedisPool() {

		// Initialize JedisPoolConfig object
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		// Initialize JedisPool object using server related properties.
		// If you are using additional properties like,{ password ,ssl.enabled etc } you
		// have to pass those
		// values into JedisPool constructor.
		JedisPool jedisPool = new JedisPool(poolConfig, redisHost, redisPort, redisTimeout);

		return jedisPool;
	}
}