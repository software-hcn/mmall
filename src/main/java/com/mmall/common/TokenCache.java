package com.mmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TokenCache {
    private static Logger logger= LoggerFactory.getLogger(TokenCache.class);
    public static final String TOKEN_PREFIX="token_";
    //lRU算法
    private static LoadingCache<String ,String > loadingCache= CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12,TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                @Override
                //默认的数据加载实现，使用get取值，key没有值时，调用这个方法进行加载
                public String load(String s) throws Exception {
                    return "null";  //不是真正的null
                }
            });
    public static void setKey(String key ,String value){
        loadingCache.put(key,value);
    }
    public static String getKey(String key){
        String value=null;
        try {
            value=loadingCache.get(key);
            if("null".equals(value)){
                return null;
            }
            return value;
        } catch (ExecutionException e) {
            logger.error("logger get error" ,e);
        }
        return null;
    }
}
