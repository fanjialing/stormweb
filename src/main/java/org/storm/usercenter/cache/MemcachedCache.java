package org.storm.usercenter.cache;


import net.rubyeye.xmemcached.MemcachedClient;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

/**
 * Created by wangwei on 15/5/6.
 */
public class MemcachedCache implements Cache {

	private final String name;
	private final MemCache memCache;

	public MemcachedCache(String name, int expire, MemcachedClient memcachedClient) {
		this.name = name;
		this.memCache = new MemCache(name, expire, memcachedClient);
	}

	public void clear() {
		memCache.clear();
	}

	public void evict(Object key) {
		memCache.delete(key.toString());
	}

	public ValueWrapper get(Object key) {
		ValueWrapper wrapper = null;
		Object value = memCache.get(key.toString());
		if (value != null) {
			wrapper = new SimpleValueWrapper(value);
		}
		return wrapper;
	}

	public Object getValue(Object key) {
		ValueWrapper wrapper = get(key.toString());
		if (wrapper != null) {
			return wrapper.get();
		}
		return wrapper;
	}

	public String getName() {
		return this.name;
	}

	public MemCache getNativeCache() {
		return this.memCache;
	}

	public void put(Object key, Object value) {
		memCache.put(key.toString(), value);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Object key, Class<T> type) {
		Object cacheValue = this.memCache.get(key.toString());
		Object value = (cacheValue != null ? cacheValue : null);
		if (type != null && !type.isInstance(value)) {
			throw new IllegalStateException("Cached value is not of required type [" + type.getName() + "]: " + value);
		}
		return (T) value;
	}

	public ValueWrapper putIfAbsent(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}