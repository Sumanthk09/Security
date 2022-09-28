package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Securitycontroller 
{
	@GetMapping("/home")
	public String homepage()
	{
		return "This is homepage";
	}
	@GetMapping("/admin")
	public String adminpage()
	{
		return "This is adminpage";
	}
	@GetMapping("/user")
	public String userpage()
	{
		return "This is userpage";
	}
}
