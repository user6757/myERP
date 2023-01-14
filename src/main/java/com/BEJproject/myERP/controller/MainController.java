package com.BEJproject.myERP.controller;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.service.MainService;
import com.BEJproject.myERP.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
public class MainController {

    @Autowired
    private MainService mainService;
    private HttpSession session;

    @RequestMapping("/main")
    public ModelAndView login(HttpServletRequest request){
        session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        MyERP_userDTO myERP_userDTO = mainService.getUser(userId);
        ModelAndView mv= new ModelAndView();
        mv.setViewName("main/main");
        mv.addObject("erp", myERP_userDTO);
        return mv;
    }

    @RequestMapping("/main/maindashboard")
    public ModelAndView maindashboard(){
        ModelAndView mv = new ModelAndView("main/maindashboard");
        return mv;
    }
    @RequestMapping("/main/mainboard")
    public ModelAndView mainBoard(){
        System.out.println("메인 게시판 페이지!");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/mainboard");
        return mv;
    }

}
