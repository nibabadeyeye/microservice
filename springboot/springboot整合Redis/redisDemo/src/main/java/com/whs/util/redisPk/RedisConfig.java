//package com.whs.util.redisPk;
//
//
//
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import com.alibaba.fastjson.JSON;
//@Configuration
////@EnableCaching
//public class RedisConfig extends CachingConfigurerSupport {
//
//	/**
//	 * redis key生成策略
//	 * target: 类
//	 * method: 方法
//	 * params: 参数
//	 * @return KeyGenerator
//	 *
//	 * 注意: 该方法只是声明了key的生成策略,还未被使用,需在@Cacheable注解中指定keyGenerator
//	 *      如: @Cacheable(value = "key", keyGenerator = "cacheKeyGenerator")
//	 */
//    @Bean
//    public KeyGenerator cacheKeyGenerator() {
//        return (target, method, params) -> {
//            StringBuilder sb = new StringBuilder();
//            sb.append(target.getClass().getName());
//            sb.append(method.getName());
//            for (Object obj : params) {
//            	// 由于参数可能不同, hashCode肯定不一样, 缓存的key也需要不一样
//                sb.append(JSON.toJSONString(obj).hashCode());
//            }
//            return sb.toString();
//        };
//    }
//
//    /**
//     * redis全局默认配置
//     * @param redisTemplate
//     * @return
//     */
////    @Bean
////    public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {
////        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
////        redisCacheManager.setUsePrefix(true);
////        // key缓存的前缀,以conf开头
////        RedisCachePrefix cachePrefix = new RedisPrefix("conf");
////        redisCacheManager.setCachePrefix(cachePrefix);
////        // key缓存的过期时间, 600秒
////        redisCacheManager.setDefaultExpiration(600L);
////        return redisCacheManager;
////    }
//
//}
