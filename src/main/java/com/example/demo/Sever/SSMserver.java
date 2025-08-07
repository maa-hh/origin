package com.example.demo.Sever;

import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.Cached;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SSMserver {
    @Autowired
    Cache cache;
    @CachePut(value = "code", key = "#num")
   /* @CacheRefresh()
    @Cached()*/
    public String getSSM(String num) {
        // 手机号哈希
        String phone = num;
        // 模拟一个 hashCode（你可以根据业务逻辑传入真实的 hashCode）
        int hash = phone.hashCode();
        // 当前系统时间（毫秒）
        long currentTime = System.currentTimeMillis();
        // 组合生成一个数字
        long raw = (long) phone.hashCode()^currentTime;
        // 取绝对值（防止负数）并取后 6 位
        int codeNum = (int) (Math.abs(raw) % 1_000_000);
        // 转成 6 位字符串（前面补 0）
        String code = String.format("%06d", codeNum);
        System.out.println("验证码: " + code);
        return code;
    }

    public Boolean check(String num, String code) {
        String ssmcode=cache.getCodeFromCache(num);
        if(ssmcode==null) System.out.println("null");
        if(code.equals(ssmcode)) return true;
        return false;
    }


}
