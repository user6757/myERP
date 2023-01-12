package com.BEJproject.myERP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

    @RequestMapping("/membership")
    public ModelAndView membership(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("membership/membershipform");
        return mv;
    }
}
