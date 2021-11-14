package com.onemoreapp.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneMoreController {

	@GetMapping("/hello")
	public String hello() {
		
		return "Spring Security !!!!";
	}
}
