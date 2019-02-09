package com.firstsads;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdsController {
	
	@RequestMapping("/savead")
	public String welcome(Model model, Ad ad) {
		
		model.addAttribute("ad", ad);

		return "ad_template";
	}

}