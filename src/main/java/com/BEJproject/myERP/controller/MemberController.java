package com.BEJproject.myERP.controller;

import com.BEJproject.myERP.dto.LoginDTO;
import com.BEJproject.myERP.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @RequestMapping("/membership")
    public ModelAndView membership(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("membership/membershipform");
        return mv;
    }

    @RequestMapping(value = "/membership/idcheck", method = {RequestMethod.POST})
    public ResponseEntity<?> idcheck(String userId){
        boolean getidcheck = memberService.idcheck(userId);
        if (getidcheck == true){
            return new ResponseEntity<>("success", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/membership/sing_up", method = {RequestMethod.POST})
    public ResponseEntity<?> singUp(LoginDTO loginDTO){
        boolean getsing_up = memberService.singUp(loginDTO);
        if (getsing_up == true){
            return new ResponseEntity<>("success", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }
}
