package com.jaikar.patent;

import com.jaikar.patent.controller.PatentController;
import com.jaikar.patent.entity.Patent;
import com.jaikar.patent.repository.PatentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PatentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatentApplication.class, args);
	}

}
