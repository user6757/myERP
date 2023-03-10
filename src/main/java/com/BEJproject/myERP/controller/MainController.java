package com.BEJproject.myERP.controller;

import com.BEJproject.myERP.dto.MyERP_mainboard;
import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.service.LoginService;
import com.BEJproject.myERP.service.MainBoardService;
import com.BEJproject.myERP.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.List;

@Controller
@Log4j2
public class MainController {

    private MainBoardService mainBoardService;
    private MemberService memberService;
    private HttpSession session;

    @Autowired
    public MainController(MainBoardService mainBoardService, MemberService memberService){
        this.mainBoardService = mainBoardService;
        this.memberService = memberService;
    }

    @RequestMapping("/main")
    public ModelAndView login(HttpServletRequest request){
        session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        MyERP_userDTO myERP_userDTO = mainBoardService.getUser(userId);
        ModelAndView mv= new ModelAndView();
        mv.setViewName("main/main");
        mv.addObject("user", myERP_userDTO);
        return mv;
    }

    @RequestMapping("/main/maindashboard")
    public ModelAndView maindashboard(){
        ModelAndView mv = new ModelAndView("main/maindashboard");
        return mv;
    }
    @RequestMapping(value = "/main/mainboard", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mainBoard(HttpServletRequest request, MyERP_mainboard myERP_mainboard){
        List<MyERP_mainboard> list = mainBoardService.boardlist(myERP_mainboard);
        session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        MyERP_userDTO userDTO = mainBoardService.getUser(userId);

        boolean modifydatecheck = false;
        log.info("??????:{}", modifydatecheck);
        for(MyERP_mainboard mainboard: list){
            if(!mainboard.getStrModifiyRegdate().equals(mainboard.getStrRegdate())){
                modifydatecheck = true;
            }
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/mainboard");
        mv.addObject("user", userDTO);
        mv.addObject("main", list);
        mv.addObject("modify", modifydatecheck);
        mv.addObject("boardname", userDTO.getUserName());
        return mv;
    }


}
