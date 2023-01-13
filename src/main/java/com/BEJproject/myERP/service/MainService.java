package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.mapper.MainMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MainService {
    @Autowired
    private MainMapper mainMapper;

    public MyERP_userDTO getUser(String userId){
        System.out.println("getuser확인!!");
        return mainMapper.getUser(userId);
    }
}
