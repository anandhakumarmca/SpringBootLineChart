package com.anandh.displaylinechart.controller;

import com.anandh.displaylinechart.repository.StudentApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Map;

@Controller
public class StudentApplicationController {

    private final StudentApplicationRepository studentApplicationRepository;

    @Autowired
    public StudentApplicationController(StudentApplicationRepository studentApplicationRepository) {
        this.studentApplicationRepository = studentApplicationRepository;
    }

    @GetMapping("/chart")
    public ModelAndView displayChart() {
    	ModelAndView mav = new ModelAndView();
        List<Map<String, Object>> applicationCounts = studentApplicationRepository.getStudentApplicationCountByApproved();
        mav.addObject("applicationCounts", applicationCounts);
        mav.setViewName("chart");
        return mav;
    }

}
