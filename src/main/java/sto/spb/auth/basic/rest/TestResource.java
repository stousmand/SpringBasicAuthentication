package sto.spb.auth.basic.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

	@GetMapping("/hello")
	public String hello() {
		return "FooBar";
	}
	
}
