package com.conpany.project;

import com.company.project.ServiceApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * unit test base class
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
@Rollback
// using some test data  for  simple and clear test
@TestPropertySource(properties = "mock.json.path=classpath:/mocks/test.json")
public abstract class BaseTester {
	public static final ObjectMapper jsonMapper = new ObjectMapper();

}
