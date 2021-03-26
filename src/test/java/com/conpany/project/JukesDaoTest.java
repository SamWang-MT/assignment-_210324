package com.conpany.project;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
public class JukesDaoTest extends BaseTester {

	@Test
	public void getMockDbContainerDatasTest() throws Exception {
		List<Jukebox> jukeboxes = MockDbContainer.getJukeboxes();
		List<JukeboxSetting> jukeSettings = MockDbContainer.getJukeSettings();
		List<JukeboxSetting> availableSettings = MockDbContainer.getAvailableSettings();
		Map<String, List<Jukebox>> availableSettingsMap = MockDbContainer.getAvailableSettingsMap();

		assertTrue("Quantity of jukeboxes in MockDbContainer  ", jukeboxes.size() == 4);
		assertTrue("Quantity of settings in MockDbContainer ", jukeSettings.size() == 5);
		assertTrue("Quantity of availableSettings in MockDbContainer ", availableSettings.size() == 4);
		assertTrue("Quantity of availableSettingsMap in MockDbContainer ", availableSettingsMap.size() == 4);
		assertNull("S2 available ", availableSettingsMap.get("S2"));
		assertTrue("Quantity of S3 available jukeboxes in MockDbContainer  ",
				availableSettingsMap.get("S3").size() == 3);

	}

}
