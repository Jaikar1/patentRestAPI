package com.jaikar.patent.repository;

import com.jaikar.patent.entity.Patent;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RedisConfigTest.class)
class PatentDaoTest {

    @Autowired
    PatentDao daoUnderTest;

    @Test
    void itShouldCheckIfRepositorySavePatents(){
        //given
        String patentName = "ABCD0000";
        Integer patentId = 5400;
        Patent patent = new Patent();
        patent.setPatent(patentName);
        patent.setId(patentId);

        Map<Integer, Patent> patentMap = new HashMap<>();
        patentMap.put(patentId, patent);
        daoUnderTest.savePatents(patentMap);
        //when
        Patent patentFinded = daoUnderTest.findPatentById(patentId);
        //then
        Assertions.assertThat(patentFinded.getPatent()).isEqualTo(patentName);
    }

    @Test
    void itShouldRetrievePatentsByItsPatentName(){
        //given
        String patentName = "ABCD0000";
        //when
        Patent patentFinded = daoUnderTest.findPatentByPatent(patentName);
        //then
        Assertions.assertThat(patentFinded.getId()).isEqualTo(5400);
    }
}