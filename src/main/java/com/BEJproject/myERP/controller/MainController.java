package com.BEJproject.myERP.controller;

import com.BEJproject.myERP.dto.MyERP_mainboard;
import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.service.MainService;
import com.BEJproject.myERP.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        log.info("유저아이디:{}", myERP_userDTO.getUserId());
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
    public ModelAndView mainBoard(String boardname){
        List<MyERP_mainboard> list = mainService.boardlist();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/mainboard");
        mv.addObject("main", list);
        mv.addObject("boardname", boardname);
        return mv;
    }

    @RequestMapping("/main/mainboardwriter")
    public ModelAndView mainBoardwriter(HttpServletRequest request, MyERP_mainboard mainboard){
        session = request.getSession();
        String userName = request.getParameter("boardname");
        String mainboardUserid = (String)session.getAttribute("userId");
        mainboard.setMainboardUserId(mainboardUserid);
        mainboard.setMainboardWriter(userName);
        ModelAndView mv = new ModelAndView();
        mv.addObject("main", mainboard);
        mv.setViewName("main/mainboardwriter");
        return mv;
    }

    @RequestMapping("/main/mainboardsave")
    public ResponseEntity<?> save(MyERP_mainboard mainboard){
        log.info("아이디:{}, 제목:{}, 내용:{}", mainboard.getMainboardUserId(), mainboard.getMainboardTitle(), mainboard.getMainboardContent());
        boolean save = mainService.boardsave(mainboard);
        if (save==true){
           return new ResponseEntity<>("success", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }





}
