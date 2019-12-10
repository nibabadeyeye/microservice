//package com.whs.util.pk;
//
//
//
//import org.tinygroup.commons.tools.StringUtil;
//
//import java.util.UUID;
//
//public class BaseKeyGenerate implements KeyGenerate{
//	@Override
//	public String generateStringKey(KeyGenerateEnum em) {
//	//	return StringUtil.getUUID()+StringUtil.getNonceStr(6);
//        return UUID.randomUUID().toString().replace("-", "");
//	}
//	@Override
//	public Long generateLongKey(KeyGenerateEnum em) {
//	//	return System.currentTimeMillis()*1000000+NumberUtil.random(6);
//        long a=33;
//        return a;
//	}
//}
