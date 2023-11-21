package com.rodrigocarvalho.projectmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = {ProjectmanagerApplication.class})
@ActiveProfiles("teste")
class ProjectmanagerApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}

}
