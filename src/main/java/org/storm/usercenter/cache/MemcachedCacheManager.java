package org.storm.usercenter.cache;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.rubyeye.xmemcached.MemcachedClient;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 * Created by wangwei on 15/5/6.
 */
public class MemcachedCacheManager implements CacheManager {

	private ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();
	private Map<String, Integer> expireMap = new HashMap<String, Integer>(); // 缓存的时间
	private MemcachedClient memcachedClient; // xmemcached的客户端

	public MemcachedCacheManager() {
	}

	protected Collection<? extends Cache> loadCaches() {
		Collection<Cache> values = cacheMap.values();
		return values;
	}

	public Cache getCache(String name) {
		Cache cache = cacheMap.get(name);
		if (cache == null) {
			Integer expire = expireMap.get(name);
			if (expire == null) {
				expire = 3600;
				expireMap.put(name, expire);
			}
			cache = new MemcachedCache(name, expire.intValue(), memcachedClient);
			cacheMap.put(name, cache);
		}
		return cache;
	}

	public MemcachedCache getMemCache(String name) {
		return (MemcachedCache) getCache(name);
	}

	public Collection<String> getCacheNames() {
		List<String> nameList = new ArrayList<String>();
		for (Cache cache : cacheMap.values()) {
			nameList.add(cache.getName());
		}
		return nameList;
	}

	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}

	public void setConfigMap(Map<String, Integer> configMap) {
		this.expireMap = configMap;
	}

	public void clearAll() {
		for (Cache cache : loadCaches()) {
			cache.clear();
		}
	}
}
