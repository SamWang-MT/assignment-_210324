package com.company.project.service;

import java.util.List;
import java.util.Optional;

import com.company.project.domain.Jukebox;
import com.company.project.domain.JukeboxSetting;

/** 
 * @ClassName: JunkesServiceInterface    
 * @author: Merdader
 * @Date: Mar. 25, 2021 10:33:44 a.m.
 * 
 * @description: 
 */

public interface JunkesServiceInterface {

	/**
	 * get Jukes By SettingId [junke's model]
	 * @param settingId
	 * @param model
	 * @param pageOffset
	 * @param pageLimit
	 * @return List<Jukebox>
	 */
	List<Jukebox> getJukesBySettingId(String settingId, Optional<String> model, int pageOffset, int pageLimit);

	/**
	 *  get  all Jukes
	 * @param pageOffset
	 * @param pageLimit
	 * @return List<Jukebox>
	 */
	List<Jukebox> getJukes(int pageOffset, int pageLimit);
	
	
	/**
	 * get all JukeSettings
	 * @param pageOffset
	 * @param pageLimit
	 * @return
	 */
	List<JukeboxSetting> getJukeSettings(int pageOffset, int pageLimit);
	
	
	/**
	 * get all Available JukeSettings
	 * @param pageOffset
	 * @param pageLimit
	 * @return
	 */
	List<JukeboxSetting> getAvailableSettings(int pageOffset, int pageLimit);
	

}