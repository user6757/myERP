package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LoginServiceImpl implements LoginService{

    private LoginMapper loginMapper;

    @Autowired
    public LoginServiceImpl(LoginMapper loginMapper){
        this.loginMapper = loginMapper;
    }

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
