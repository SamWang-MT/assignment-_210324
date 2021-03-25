package com.conpany.project;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.company.project.dao.MockDbContainer;
import com.company.project.domain.Jukebox;
import com.company.project.domain.JukeboxSetting;

/**
 * 
 * Test MockDbContainer
 *
 */
public class JunkesDaoTest extends BaseTester {

	@Test
	public void getMockDbContainerDatasTest() throws Exception {
		List<Jukebox> jukeboxes = MockDbContainer.getJukeboxes();
		List<JukeboxSetting> jukeSettings = MockDbContainer.getJukeSettings();
		List<JukeboxSetting> availableSettings = MockDbContainer.getAvailableSettings();
		Map<String, List<Jukebox>> availableSettingsMap = MockDbContainer.getAvailableSettingsMap();
		
		
		
		
		
	}

}
