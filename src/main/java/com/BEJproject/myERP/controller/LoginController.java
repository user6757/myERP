package com.BEJproject.myERP.controller;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.service.LoginService;
import com.BEJproject.myERP.service.LoginServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
public class LoginController {

    private HttpSession session;
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv= new ModelAndView();
        mv.setViewName("login/login");
        return mv;
    }

    @RequestMapping(value = "/login/sing_in", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<Boolean> singIn(MyERP_userDTO myERPuserDTO, HttpServletRequest request){
        boolean login = loginService.singIn(myERPuserDTO, request);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request){
        session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
