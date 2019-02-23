package com.firstsads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdsController {
	
	private Map<Integer,Ad> ads = new ConcurrentHashMap<Integer, Ad>();
	private AtomicInteger id = new AtomicInteger();
	
	@RequestMapping("/savead")
	public String saveAd(Model model, Ad ad) {
		
		Integer newId = id.getAndIncrement();
		ad.setId(newId);
		ads.put(newId, ad);

		return "ads_saving";
	}
	
	@RequestMapping("/")
	public String noticeboard(Model model) {
		
		model.addAttribute("ads", ads.values());
		return "noticeboard";
	}
	
	@RequestMapping("/ad/{id}")
	public String adResume(Model model, @PathVariable Integer id) {
		
		model.addAttribute("ad", ads.get(id));
		return "ads_resume";
	}
}