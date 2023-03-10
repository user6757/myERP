package com.BEJproject.myERP.controller;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Member;
import java.security.NoSuchAlgorithmException;

@Controller
@Log4j2
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
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
    public ResponseEntity<?> singUp(MyERP_userDTO myERPuserDTO) throws Exception{
        boolean getsing_up = memberService.singUp(myERPuserDTO);
        if (getsing_up == true){
            return new ResponseEntity<>("success", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }
}
