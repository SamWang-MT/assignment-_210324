package com.conpany.project;

import com.company.project.ServiceApplication;
import com.company.project.domain.Jukebox;
import com.company.project.service.JukesService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;

/**
 * unit test base class
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
@Rollback
@TestPropertySource(properties = "mock.json.path=classpath:/mocks/test.json")
public abstract class BaseTester {
	public static  final   ObjectMapper jsonMapper =  new ObjectMapper();
	
}
