package com.nuvole.framework.cache;

import cn.hutool.core.convert.Convert;
import com.nuvole.framework.utils.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

@Component
@Slf4j
public class RedisCache<K, V> implements Cache<K, V> {

    @Resource
    private JedisUtil jedisUtil;

    private static final String CACHE_PREFIX = "nuvole-cache:";

    private byte[] getKey(K k) {
        String key = Convert.toStr(k);
        if (key.startsWith(CACHE_PREFIX)) {
            return key.getBytes();
        }
        log.info(" getKey ...  {} ", key);
        return (CACHE_PREFIX + key).getBytes();
    }

    @Override
    public V get(K key) throws CacheException {
        log.info(" get... , key is {} ", key);
        byte[] value = jedisUtil.get(getKey(key));
        if (value != null) {
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }

    @Override
    public V put(K key, V value) throws CacheException {
        log.info(" put... , key is {} ", key);
        byte[] keybyte = getKey(key);
        byte[] valuebyte = SerializationUtils.serialize(value);
        jedisUtil.set(keybyte, valuebyte);
        jedisUtil.expire(keybyte, 600);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        V previos = get(key);
        byte[] keybyte = getKey(key);
        jedisUtil.del(keybyte);
        log.info(" remove... , key is {} ", key);
        return previos;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        if (keys() == null)
            return 0;
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
