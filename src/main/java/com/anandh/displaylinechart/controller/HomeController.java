package com.anandh.displaylinechart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/test")
	public ModelAndView loadHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("line-chart");
		return mav;
	}
}
