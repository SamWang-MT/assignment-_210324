package com.company.project.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.company.project.core.PageUtil;
import com.company.project.dao.MockDbContainer;
import com.company.project.domain.Jukebox;
import com.company.project.domain.JukeboxSetting;
import com.company.project.service.JukesServiceInterface;

@Service
public class JukesService implements JukesServiceInterface {

	@Override
	public List<Jukebox> getJukesBySettingId(String settingId, Optional<String> model, int pageOffset, int pageLimit) {

//	Map<String, List<Jukebox>> availableSettingsMap = MockDbContainer.getAvailableSettingsMap();
		List<Jukebox> jukeboxesbySetting = MockDbContainer.getJukeboxesbySetting(settingId);
//	deepCloneList
		deepCloneList(jukeboxesbySetting);
		List<Jukebox> jukeboxesCloned = deepCloneList(jukeboxesbySetting);

// Filter by model
		if (model.isPresent()) {
			Iterator<Jukebox> iterator = jukeboxesCloned.iterator();
			while (iterator.hasNext()) {
				if (!model.get().equals(iterator.next().getModel())) {
					iterator.remove();
				}
			}
		}
		return PageUtil.startPage(jukeboxesCloned, pageOffset, pageLimit);

	}

	private List<Jukebox> deepCloneList(List<Jukebox> jukeboxesbySetting) {
		if (jukeboxesbySetting == null || jukeboxesbySetting.isEmpty()) {
			return jukeboxesbySetting;
		}
		List<Jukebox> clonedjukeboxs = new ArrayList<Jukebox>();
		for (Jukebox jukebox : jukeboxesbySetting) {
			try { // need to customize specific exceptions and handle them uniformly
				clonedjukeboxs.add((Jukebox) BeanUtils.cloneBean(jukebox));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return clonedjukeboxs;
	}

	@Override
	public List<Jukebox> getJukes(int pageOffset, int pageLimit) {
		List<Jukebox> jukeboxes = MockDbContainer.getJukeboxes();
		return PageUtil.startPage(jukeboxes, pageOffset, pageLimit);
	}

	@Override
	public List<JukeboxSetting> getJukeSettings(int pageOffset, int pageLimit) {
		List<JukeboxSetting> jukeSettings = MockDbContainer.getJukeSettings();
		return PageUtil.startPage(jukeSettings, pageOffset, pageLimit);
	}

	@Override
	public List<JukeboxSetting> getAvailableSettings(int pageOffset, int pageLimit) {
		List<JukeboxSetting> availableSettings = MockDbContainer.getAvailableSettings();
		return PageUtil.startPage(availableSettings, pageOffset, pageLimit);
	}

}
