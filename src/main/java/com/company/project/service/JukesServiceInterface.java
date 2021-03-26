package com.company.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.support.PagedListHolder;

import com.company.project.domain.Jukebox;
import com.company.project.domain.JukeboxSetting;



public interface JukesServiceInterface {
	
/**
 * 
 * @param settingId
 * @param model
 * @param offset
 * @param limit
 * @return PagedListHolder<Jukebox>
 */
	PagedListHolder<Jukebox> getPaginateJukesByIdandModel(String settingId, Optional<String> model, Optional<Integer> offset,
			Optional<Integer> limit);

	
	/**
	 * @param settingId
	 * @param model
	 * @param offset
	 * @param limit
	 * @return List<Jukebox>
	 */
	List<Jukebox> getPaginatedListBySettingIdandModel(String settingId, Optional<String> model,
			Optional<Integer> offset, Optional<Integer> limit);

/**
 * 
 * @param offset
 * @param limit
 * @return
 */
	List<Jukebox> getPaginatedJukesList(Optional<Integer> offset, Optional<Integer> limit);
/**
 * 
 * @param offset
 * @param limit
 * @return
 */

	List<JukeboxSetting> getPaginatedJukeSettingList(Optional<Integer> offset, Optional<Integer> limit);

}