package com.lcwd.user.service.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	// URL Versioning
	
	@GetMapping("/v1/person")
	public PersonV1 getdetailVersion1() {
		return new PersonV1("Cristiano Ronaldo");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getdetailVersion2() {
		return new PersonV2("Cristiano ","Ronaldo");
	}
	
	// RequestParam Versioning
	
	@GetMapping(path="/person", params="version1")
	public PersonV1 getdetailByRequstParamV1() {
		return new PersonV1("Cristiano Ronaldo");
	}
	
	@GetMapping(path="/person",params="version2")
	public PersonV2 getdetailByRequstParamV2() {
		return new PersonV2("Cristiano ","Ronaldo");
	}
	
}
