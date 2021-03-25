package com.conpany.project;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import com.company.project.domain.Jukebox;
import com.company.project.service.JukesServiceInterface;

public class JukesServiceTest extends BaseTester {

	@Resource
	private JukesServiceInterface jukesService;

//
//			=================================
//			Query PARM :S0, empty, PAGE1-5
//			[	{"id":"J1","model":"model-A","components":[{"name":"req1"},{"name":"req2"},{"name":"req3"}]},
//				{"id":"J2","model":"model-B","components":[{"name":"req1"},{"name":"req2"}]},	
//				{"id":"J3","model":"model-B","components":[{"name":"req2"}]},
//				{"id":"J4","model":"model-A","components":[{"name":"req4"}]}
//			]
//			=================================
//			Query PARM :S3, model-B, PAGE1-5
//			[	{"id":"J2","model":"model-B","components":[{"name":"req1"},{"name":"req2"}]},
//				{"id":"J3","model":"model-B","components":[{"name":"req2"}]}]
//			=================================
//			Query PARM :S2, model-B, PAGE1-5
//			null
//			=================================
//			Query PARM :S0, empty, PAGE2-2
//			[	{"id":"J3","model":"model-B","components":[{"name":"req2"}]},
//				{"id":"J4","model":"model-A","components":[{"name":"req4"}]}]
//
//	

	@Test
	public void getJukesBySettingIdTest() throws Exception {
		Map<String, List<Jukebox>> testResultMap = new HashMap<String, List<Jukebox>>();

		testResultMap.put("Query PARM :S0, empty, PAGE1-5",
				jukesService.getJukesBySettingId("S0", Optional.empty(), 1, 5));
		testResultMap.put("Query PARM :S0, empty, PAGE2-2",
				jukesService.getJukesBySettingId("S0", Optional.empty(), 2, 2));
		testResultMap.put("Query PARM :S3, model-B, PAGE1-5",
				jukesService.getJukesBySettingId("S3", Optional.of("model-B"), 1, 5));
		testResultMap.put("Query PARM :S2, empty, PAGE1-5",
				jukesService.getJukesBySettingId("S2", Optional.empty(), 1, 5));

		assertTrue("Query PARM :S0, empty, PAGE1-5", testResultMap.get("Query PARM :S0, empty, PAGE1-5").size() == 4);
		assertTrue("Query PARM :S0, empty, PAGE2-2", testResultMap.get("Query PARM :S0, empty, PAGE2-2").size() == 2);
		assertTrue("Query PARM :S3, model-B, PAGE1-5",
				testResultMap.get("Query PARM :S3, model-B, PAGE1-5").size() == 2);
		assertNull("Query PARM :S2, empty, PAGE1-5", testResultMap.get("Query PARM :S2, empty, PAGE1-5"));

		for (String queryParm : testResultMap.keySet()) {
			System.out.println("=================================");
			System.out.println(queryParm);
			System.out.println(jsonMapper.writeValueAsString(testResultMap.get(queryParm)));
		}
	}

}