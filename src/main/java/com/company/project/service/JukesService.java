package com.company.project.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.company.project.core.PageUtil;
import com.company.project.dao.MockDbContainer;
import com.company.project.domain.Jukebox;
import com.company.project.domain.JukeboxSetting;
import com.company.project.domain.MockDbEntity;

@Service
public class JukesService {

	public List<Jukebox> getJukesBySettingId(String settingId, Optional<String> model, int pageOffset, int pageLimit) {
		{
			List<Jukebox> jukeboxes = MockDbContainer.getJukeboxes();
			List<JukeboxSetting> jukeSettings = MockDbContainer.getJukeSettings();
			List<JukeboxSetting> availableSettings = MockDbContainer.getAvailableSettings();
			
			
			List<Jukebox> jukeboxesbySetting = MockDbContainer.getJukeboxesbySetting(settingId);
			// Filter by model
			if (model.isPresent()) {
				Iterator<Jukebox> iterator = jukeboxesbySetting.iterator();
				while (iterator.hasNext()) {
					if (!model.get().equals(iterator.next().getModel())) {
						iterator.remove();
					}
				}
			}
			return PageUtil.startPage(jukeboxesbySetting, pageOffset, pageLimit);
		}

	}

}
