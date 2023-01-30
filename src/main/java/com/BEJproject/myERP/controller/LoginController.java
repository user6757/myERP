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
import java.util.List;

@Controller
@Log4j2
public class LoginController {

    private HttpSession session;
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }
    @RequestMapping("/login/login_login")
    public String login(){
        return null;
    }

    @RequestMapping(value = "/login/sing_in", method = {RequestMethod.POST})
    public ResponseEntity<Boolean> singIn(MyERP_userDTO myERPuserDTO, HttpServletRequest request) throws Exception{
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

    @RequestMapping("/login/login_idfind")
    public String idfind(){
        System.out.println("확인!");
        return null;
    }

    @RequestMapping(value = "/login/accountfind", method = {RequestMethod.POST})
    public ResponseEntity<?> accountfind(MyERP_userDTO myERP_userDTO){
        log.info("받은 이름:{}, 받은 핸드폰번호:{}", myERP_userDTO.getUserName(), myERP_userDTO.getUserTel());
        int usercheck = loginService.accountfind(myERP_userDTO);

        if (usercheck > 0){
            return new ResponseEntity<>("success", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/login/getaccount", method = {RequestMethod.POST})
    public ModelAndView getaccount(MyERP_userDTO userDTO){
        List<MyERP_userDTO> accountlist = loginService.getaccount(userDTO);
        ModelAndView mv = new ModelAndView("login/login_idfind");
        if (accountlist != null){
            mv.addObject("username", userDTO.getUserName());
            mv.addObject("account", accountlist);
            return mv;
        }else{
            return mv;
        }
    }

    @RequestMapping("/login/login_pwfind")
    public String pwfind(){
        return null;
    }

}
