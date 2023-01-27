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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
public class MainBoardController {

    private MainBoardService mainBoardService;
    private HttpSession session;

    @Autowired
    public MainBoardController(MainBoardService mainBoardService){
        this.mainBoardService = mainBoardService;
    }

    @RequestMapping(value = "/main/mainboardwriter", method = {RequestMethod.POST})
    public ModelAndView mainBoardwriter(HttpServletRequest request, String mainboardWriter){

        session = request.getSession();
        String mainboardUserid = (String)session.getAttribute("userId");

        ModelAndView mv = new ModelAndView();
        mv.addObject("mainboardWriter", mainboardWriter);
        mv.addObject("mainboardUserId", mainboardUserid);
        mv.setViewName("main/mainboardwriter");
        return mv;
    }

    @RequestMapping(value = "/main/detaile", method = {RequestMethod.GET})
    public ModelAndView detaile(String mainboardBno){
        log.info("받은번호:{}", mainboardBno);
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
        log.info("");
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

    @RequestMapping("/main/delete")
    public ResponseEntity<?> delete(Integer mainboardBno){
        log.info("delete 받은 번호:{}", mainboardBno);
        boolean getdata = mainBoardService.delete(mainboardBno);
        if (getdata == true){
            return new ResponseEntity<>("글삭제가 정상적으로 완료되었습니다.", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("글삭제가 실패되었습니다.", HttpStatus.BAD_REQUEST);
        }
    }

}
