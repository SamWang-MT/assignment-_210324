package com.company.project.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;

import javax.annotation.Resource;

import java.util.List;

/**
 * 
 */
@RestController
@RequestMapping("/api/material")
public class MaterialController {
//	@Resource
//	private MaterialService materialService;

	@SuppressWarnings({ "rawtypes" })
	@GetMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
			@RequestParam String storageBin) {


// materialsService.findByCondition();
//		Page<Object> startPage = PageHelper.startPage(page, size);
//		List<StorageInfo> list = materialService.listMaterialsByStorageBin(storageBin.trim());
//		startPage.add(list);
		/*
		 * PageInfo<StorageInfo> pageInfo = null; if (page == 0 ||size == 0 ) { pageInfo
		 * = new PageInfo<StorageInfo>(list); }else { pageInfo =
		 * PageInfoUtils.list2PageInfo(list, page, size);
		 * 
		 * }
		 */
		return ResultGenerator.genSuccessResult();
	}

	@SuppressWarnings({ "rawtypes" })
	@PostMapping("/listAbnormal")
	public Result listAbnormal(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size) {

		// materialsService.findByCondition();
//		Page<Object> startPage = PageHelper.startPage(page, size);
//		List<StorageInfo> list = materialService.listAbnormalPosition();
//
		return ResultGenerator.genSuccessResult();
	}

}
