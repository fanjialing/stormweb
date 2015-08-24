package org.storm.usercenter.cache;


/**
 * Created by wangwei on 15/5/7.
 */
public class CacheKeyGenarator {

	public static String genarateCacheKey(Object... keys) {
		StringBuilder key = new StringBuilder();
		for (Object str : keys) {
			key.append("_" + str);
		}
		return key.toString();
	}
}
