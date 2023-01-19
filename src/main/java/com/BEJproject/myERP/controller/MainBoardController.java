package com.BEJproject.myERP.controller;

import com.BEJproject.myERP.dto.MyERP_mainboard;
import com.BEJproject.myERP.service.MainBoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
public class MainBoardController {

    private MainBoardService mainBoardService;

    @Autowired
    public MainBoardController(MainBoardService mainBoardService){
        this.mainBoardService = mainBoardService;
    }

    @RequestMapping(value = "/main/detaile", method = {RequestMethod.GET})
    public ModelAndView detaile(String mainboardBno){
        MyERP_mainboard mainboard = mainBoardService.getboard(mainboardBno);
        ModelAndView mv = new ModelAndView("main/mainboardDetaile");
        if(mainboard != null){
            mv.addObject("main", mainboard);
            return mv;
        }else{
            mv.setViewName("main/mainboard");
            return mv;
        }
    }

    @RequestMapping("/main/mainboardsave")
    public ResponseEntity<?> save(MyERP_mainboard mainboard){
        boolean save = mainBoardService.boardsave(mainboard);
        if (save==true){
            return new ResponseEntity<>("success", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/main/modify")
    public ResponseEntity<?> modify(MyERP_mainboard mainboard){
        boolean getdata = mainBoardService.boardmodify(mainboard);
        if (getdata ==true){

            ResponseEntity<?> response = new ResponseEntity<>("success", HttpStatus.OK);
            return response;
        }else{
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }

    }

}