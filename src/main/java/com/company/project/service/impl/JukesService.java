package com.company.project.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;

import com.company.project.dao.MockDbContainer;
import com.company.project.domain.Jukebox;
import com.company.project.domain.JukeboxSetting;
import com.company.project.service.JukesServiceInterface;

@Service
//public class JukesService implements JukesServiceInterface {
public class JukesService implements JukesServiceInterface {
	@Value("${api.default.pagesize}")
	private int defaultPageSize;

	@Override
	public PagedListHolder<Jukebox> getPaginateJukesByIdandModel(String settingId, Optional<String> model,
			Optional<Integer> offset, Optional<Integer> limit) {

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
		int pageLimit = limit.orElse(defaultPageSize);
		int pageOffset = offset.orElse(1);
		PagedListHolder<Jukebox> pagedListHolder = new PagedListHolder<Jukebox>(jukeboxesCloned);
		pagedListHolder.setPage(pageOffset);
		pagedListHolder.setPageSize(pageLimit);
		return pagedListHolder;
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
	public List<Jukebox> getPaginatedListBySettingIdandModel(String settingId, Optional<String> model,
			Optional<Integer> offset, Optional<Integer> limit) {
		return getPaginateJukesByIdandModel(settingId, model, offset, limit).getPageList();
	}

	@Override
	public List<Jukebox> getPaginatedJukesList(Optional<Integer> offset, Optional<Integer> limit) {
		List<Jukebox> jukeboxes = MockDbContainer.getJukeboxes();
		PagedListHolder<Jukebox> pagedListHolder = new PagedListHolder<Jukebox>(jukeboxes);
		
		pagedListHolder.setPage(offset.orElse(1));
		pagedListHolder.setPageSize(limit.orElse(defaultPageSize));
		return pagedListHolder.getPageList();
	}

	@Override
	public List<JukeboxSetting> getPaginatedJukeSettingList(Optional<Integer> offset, Optional<Integer> limit) {
		List<JukeboxSetting> jukeSettings = MockDbContainer.getJukeSettings();
		PagedListHolder<JukeboxSetting> pagedListHolder = new PagedListHolder<JukeboxSetting>(jukeSettings);
		
		pagedListHolder.setPage(offset.orElse(1));
		pagedListHolder.setPageSize(limit.orElse(defaultPageSize));
		return pagedListHolder.getPageList();
	}


}
