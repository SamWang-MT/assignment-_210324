package com.conpany.project;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import com.company.project.domain.Jukebox;
import com.company.project.service.JukesService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JukesServiceTest extends BaseTester {

	@Resource
	private JukesService jukesService;;

	@Test
	public void get_settingId_and_model_present__Expect_200_OK() throws Exception {
//		List<Jukebox> jukesBySettingId = jukesService.getJukesBySettingId("S0", Optional.empty(), 1, 5);
		List<Jukebox> jukesBySettingId = jukesService.getJukesBySettingId("S0", Optional.of("model-A"), 1, 5);
//		System.out.println(new ObjectMapper().writeValueAsString(jukesBySettingId));
		
		for (Jukebox jukebox : jukesBySettingId) {
			System.out.println(new ObjectMapper().writeValueAsString(jukebox));
		}
	}

}