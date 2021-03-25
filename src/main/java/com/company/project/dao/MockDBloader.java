package com.company.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.company.project.domain.MockDbEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MockDBloader implements ApplicationRunner {

	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private ResourceLoader resourceLoader;

//	public static MockDbEntity mockDbEntity;

	@Value("${mock.json.path}")
	private String mockJsonFilePath;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Resource jsonFile = resourceLoader.getResource(mockJsonFilePath);
		MockDbEntity mockDbEntity = objectMapper.readerFor(MockDbEntity.class).readValue(jsonFile.getInputStream());

		MockDbContainer.initContainer(mockDbEntity);

//		Settings settings = MockDBloader.mockDbEntity.getSettings();
//		List<Jukebox> jukeboxes = MockDBloader.mockDbEntity.getJukes();
//		List<JukeboxSetting> jukeboxSettings = MockDBloader.mockDbEntity.getJukeboxSettings();

	}

}
