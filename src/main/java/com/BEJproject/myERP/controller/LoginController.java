package com.BEJproject.myERP.controller;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
@RequiredArgsConstructor
@Log4j2
public class LoginController {

    private final LoginService loginService;
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv= new ModelAndView();
        mv.setViewName("login/login");
        return mv;
    }

    @RequestMapping(value = "/login/sing_in", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<Boolean> singIn(MyERP_userDTO myERPuserDTO, HttpServletRequest request){
        boolean login = loginService.singIn(myERPuserDTO);
        if (login == true){
            HttpSession userid = request.getSession();
            userid.setMaxInactiveInterval(1800);
            userid.setAttribute("userId", myERPuserDTO.getUserId());
        }

        return new ResponseEntity<>(login, HttpStatus.OK);

    }
}
