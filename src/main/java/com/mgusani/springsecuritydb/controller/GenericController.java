package com.mgusani.springsecuritydb.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest-api")
@RestController
public class GenericController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello World !";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/secure/hello-admin")
	public String secureHello() {
		return "Hello Admin !";
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/secure/hello-user")
    public String alternate() {
        return "Hello User";
    }
}
