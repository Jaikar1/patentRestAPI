package com.jaikar.patent.controller;

import com.jaikar.patent.entity.Patent;
import com.jaikar.patent.repository.PatentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/patent")
public class PatentController {

    @Autowired
    private PatentDao dao;

    @GetMapping("/{id}")
    public Patent findPatents(@PathVariable int id){
        return dao.findPatentById(id);
    }

    @GetMapping("/name/{patent}")
    public Patent findPatentsByPatent(@PathVariable String patent){
        return dao.findPatentByPatent(patent);
    }

    @GetMapping("")
    public void savePatents(){
        Map<Integer, Patent> patentsMap = new HashMap<>();
        int id = 1;

        for(char alphabet = 'A'; alphabet <= 'Z'; alphabet++ )
        {
            final String currentLetter = "" + alphabet;
            String formattedPatentLetters = Stream.generate(() -> currentLetter).limit(4).collect(Collectors.joining());
            for(int patentNumber = 0; patentNumber <= 999; patentNumber++){
                String formattedPatentNumber = String.format("%03d", patentNumber);
                Patent patent = new Patent();
                patent.setPatent(formattedPatentLetters + formattedPatentNumber);
                patent.setId(id);
                patentsMap.put(id, patent);
                id++;
            }
        }
        dao.savePatents(patentsMap);
        System.out.println("Finished");
    }
}
