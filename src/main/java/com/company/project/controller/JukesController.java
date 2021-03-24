package com.company.project.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.core.ProjectConstant;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.domain.Jukebox;
import com.company.project.service.JukesService;

@RestController
@RequestMapping(ProjectConstant.BASE_URL)
public class JukesController {
	@Resource
	private JukesService jukesService;
	
	@Value("${api.default.pagesize}")
	private int defaultPageSize;

	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Get Jukeboxs for a Setting.", notes = "", response = Jukebox.class, responseContainer = "List")
	@GetMapping(ProjectConstant.BASE_JUKES_URL)
	public Result<List<Jukebox>> getJukebox(
			@ApiParam(value = "Setting id (required)", required = true, example = "e9869bbe-887f-4d0a-bb9d-b81eb55fbf0a") @RequestParam String settingId,
			@ApiParam(value = "A specific jukebox model Model name (optional)", example = "fusion") @RequestParam(required = false) Optional<String> model,
			@ApiParam(value = "Index start the page (optional)") @RequestParam(required = false) Optional<Integer> offset,
			@ApiParam(value = "Page size (optional)") @RequestParam(required = false) Optional<Integer> limit) {
		
		int pageLimit = limit.orElse(defaultPageSize);
		int pageOffset = offset.orElse(1);
		
		List<Jukebox> jukes = jukesService.getJukesBySettingId(settingId, model, pageOffset, pageLimit);

		return (jukes==null|| jukes.isEmpty()) ? ResultGenerator.genEmptyResultResult() : ResultGenerator.genSuccessResult(jukes);
	}

}
