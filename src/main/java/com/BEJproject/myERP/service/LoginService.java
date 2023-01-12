package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class LoginService {

    private final LoginMapper loginMapper;

    public boolean singIn(MyERP_userDTO myERPuserDTO){
        int getuser = loginMapper.singIn(myERPuserDTO);
        boolean pathreult = true;
        if (getuser > 0){
            return pathreult;
        }else{
            return pathreult = false;
        }

    }

}
