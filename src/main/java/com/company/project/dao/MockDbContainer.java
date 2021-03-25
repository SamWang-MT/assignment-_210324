package com.company.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import com.company.project.domain.Jukebox;
import com.company.project.domain.JukeboxSetting;
import com.company.project.domain.MockDbEntity;

/**
 * 
 * @author Administrator
 *
 */
public class MockDbContainer {
	public static MockDbEntity mockDbEntity;
	private static Map<String, List<Jukebox>> settingsAvailableJukeMap = new HashMap<String, List<Jukebox>>();
	private static List<JukeboxSetting> availableSettings = new ArrayList<JukeboxSetting>();

	public MockDbContainer() {
		super();
	}

	public static void initContainer(MockDbEntity mockDb) {
		if (mockDbEntity != null) {
			return;
		}
		mockDbEntity = mockDb;
		creatSetttingsMap(mockDbEntity);
	}

	private static void creatSetttingsMap(MockDbEntity mockDb) {

		List<Jukebox> jukes = mockDb.getJukes();
		List<JukeboxSetting> jukeboxSettings = mockDbEntity.getJukeboxSettings();

		for (JukeboxSetting setting : jukeboxSettings) {
			String settingId = setting.getId();
			Set<String> requires = setting.getRequires();
			List<Jukebox> availableJukeBoxesList = new ArrayList<Jukebox>();
			// search for available jukes
			for (Jukebox juke : jukes) {
				if (juke.getComponentsNamesSet().containsAll(requires)) {
					availableJukeBoxesList.add(juke);
				}
			}
			// add setting and juke list to map
			if (!CollectionUtils.isEmpty(availableJukeBoxesList)) {
				settingsAvailableJukeMap.put(settingId, availableJukeBoxesList);
				availableSettings.add(setting);
			}
		}

	}

	public static List<Jukebox> getJukeboxes() {
		return mockDbEntity.getJukes();
	}

	public static List<JukeboxSetting> getJukeSettings() {
		return mockDbEntity.getJukeboxSettings();
	}

	public static List<Jukebox> getJukeboxesbySetting(String settingId) {
		return settingsAvailableJukeMap.get(settingId);
	}

	public static List<JukeboxSetting> getAvailableSettings() {
		return availableSettings;
	}

	public static Map<String, List<Jukebox>> getAvailableSettingsMap() {

		return settingsAvailableJukeMap;

	}

}
