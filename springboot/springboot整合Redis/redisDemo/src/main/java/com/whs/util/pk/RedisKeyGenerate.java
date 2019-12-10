//package com.whs.util.pk;
//
//import com.sun.javaws.exceptions.CacheAccessException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//public class RedisKeyGenerate implements KeyGenerate{
//
//	private final Logger logger = LoggerFactory.getLogger(RedisKeyGenerate.class);
//	private final String SEQUENCE_KEY = "SEQ";
//	@Autowired
//	@Qualifier("redisClientSupport")
//	private RedisClientSupport redisClientSupport;
//	@Override
//	public String generateStringKey(KeyGenerateEnum em) {
//		Long key = generateLongKey(em);
//		if (key!=null) {
//			return key.toString();
//		}
//		//为了防止redis挂了程序能够继续运行
//		return new BaseKeyGenerate().generateStringKey(em);
//	}
//
//	@Override
//	public Long generateLongKey(KeyGenerateEnum em) {
//		synchronized (em) {
//			try {
//				Long key = redisClientSupport.incrementHash(SEQUENCE_KEY, em.name(), 1l);
//				if (key != null) {
//					return key;
//				}
//			} catch (CacheAccessException e) {
//				logger.warn("generateStringKey(KeyGenerateEnum) - exception ignored", e); //$NON-NLS-1$
//			}
//		}
//		//为了防止redis挂了程序能够继续运行
//		return new BaseKeyGenerate().generateLongKey(em);
//	}
//
//}
