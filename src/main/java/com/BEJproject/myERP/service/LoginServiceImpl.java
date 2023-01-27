package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@Log4j2
public class LoginServiceImpl implements LoginService{

    private LoginMapper loginMapper;
    private HttpSession session;

    @Autowired
    public LoginServiceImpl(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    public boolean singIn(MyERP_userDTO myERPuserDTO, HttpServletRequest request){

        int getuser = loginMapper.singIn(myERPuserDTO);

        boolean pathreult = true;
        if (getuser > 0){
            session = request.getSession();
            session.setAttribute("userId", myERPuserDTO.getUserId());
            session.setMaxInactiveInterval(18000);                                      //세션유지 5시간 설정
            return pathreult;
        }else{
            return pathreult = false;
        }

    }

}
