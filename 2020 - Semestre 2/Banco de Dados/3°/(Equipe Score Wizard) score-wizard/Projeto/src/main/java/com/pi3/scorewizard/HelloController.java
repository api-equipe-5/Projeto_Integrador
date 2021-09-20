package com.pi3.scorewizard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/indexerror")
	public String loginerror() {
		return "indexerror";
	}
	
}