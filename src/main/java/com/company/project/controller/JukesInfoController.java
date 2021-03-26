package com.company.project.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.core.ProjectConstant;
import com.company.project.domain.Jukebox;
import com.company.project.domain.JukeboxSetting;
import com.company.project.service.JukesService;

/**
 * Jukebox API : Get all jukes. Settings API : Get all Settings.
 * 
 * @author sam wang
 */

@RestController
@RequestMapping(ProjectConstant.BASE_URL)
public class JukesInfoController {
	@Resource
	private JukesService jukesService;

	@Value("${api.default.pagesize}")
	private int defaultPageSize;

	@ApiOperation(value = "Get Jukeboxs", notes = "Get all jukes", response = Jukebox.class, responseContainer = "List")
	@GetMapping(ProjectConstant.GET_JUKES_URL)
	public ResponseEntity<List<Jukebox>> getJukes(
			@ApiParam(value = "Index start the page (optional) [Default value is 1]") @RequestParam(required = false) Optional<Integer> offset,
			@ApiParam(value = "Page size (optional) [default value is 20]") @RequestParam(required = false) Optional<Integer> limit) {

		return ResponseEntity.ok()
				.body(jukesService.getPaginatedJukesList( offset, limit));
	}

	@ApiOperation(value = "Get Jukesettins", notes = "Get all juke settins", response = Jukebox.class, responseContainer = "List")
	@GetMapping(ProjectConstant.GET_SETTINGS_URL)
	public ResponseEntity<List<JukeboxSetting>> getSettings(
			@ApiParam(value = "Index start the page (optional) [Default value is 1]") @RequestParam(required = false) Optional<Integer> offset,
			@ApiParam(value = "Page size (optional) [default value is 20") @RequestParam(required = false) Optional<Integer> limit) {

		return ResponseEntity.ok()
				.body(jukesService.getPaginatedJukeSettingList( offset, limit));

		
	}

}
