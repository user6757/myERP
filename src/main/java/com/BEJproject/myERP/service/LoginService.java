package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.LoginDTO;
import com.BEJproject.myERP.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class LoginService {

    private final LoginMapper loginMapper;

    public boolean singIn(LoginDTO loginDTO){
        int getuser = loginMapper.singIn(loginDTO);
        boolean pathreult = true;
        if (getuser > 0){
            return pathreult;
        }else{
            return pathreult = false;
        }

    }

}
