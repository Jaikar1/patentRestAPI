package com.jaikar.patent.repository;

import com.jaikar.patent.entity.Patent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PatentDao {

    public static final String HASH_KEY = "Patent";

    @Autowired
    private RedisTemplate template;

    public void savePatents(Map<Integer, Patent> patent) {
        template.opsForHash().putAll(HASH_KEY, patent);
    }

    public Patent findPatentById(int id){
        return (Patent) template.opsForHash().get(HASH_KEY, id);
    }

    public Patent findPatentByPatent(String patent){
        List<Patent> patents = template.opsForHash().values(HASH_KEY);
        Patent resultPatent = patents.stream()
                .filter(patentObj -> patent.equals(patentObj.getPatent()))
                .findAny()
                .orElse(null);
        return resultPatent;
    }
}
