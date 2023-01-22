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
    @RequestMapping("/main/mainboard")
    public ModelAndView mainBoard(HttpServletRequest request){
        List<MyERP_mainboard> list = mainBoardService.boardlist();
        session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        String userName = memberService.getuserName(userId);

        int mainboardBno = 0;
        boolean modifydatecheck = false;
        log.info("날짜:{}", modifydatecheck);
        for(MyERP_mainboard mainboard: list){
            mainboardBno = mainboard.getMainboardBno();
            if(!mainboard.getStrModifiyRegdate().equals(mainboard.getStrRegdate())){
                modifydatecheck = true;
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/mainboard");
        mv.addObject("mainboardBno", mainboardBno);
        mv.addObject("main", list);
        mv.addObject("modify", modifydatecheck);
        mv.addObject("boardname", userName);
        return mv;
    }

    @RequestMapping("/main/mainboardwriter")
    public ModelAndView mainBoardwriter(HttpServletRequest request, String mainboardWriter){

        session = request.getSession();
        String mainboardUserid = (String)session.getAttribute("userId");

        ModelAndView mv = new ModelAndView();
        mv.addObject("mainboardWriter", mainboardWriter);
        mv.addObject("mainboardUserId", mainboardUserid);
        mv.setViewName("main/mainboardwriter");
        return mv;
    }


}
