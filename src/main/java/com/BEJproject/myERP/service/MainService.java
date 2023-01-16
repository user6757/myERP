package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_mainboard;
import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.mapper.MainMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class MainService {
    @Autowired
    private MainMapper mainMapper;

    public MyERP_userDTO getUser(String userId){
        return mainMapper.getUser(userId);
    }

    public boolean boardsave(MyERP_mainboard myERP_mainboard){
        return mainMapper.boardsave(myERP_mainboard);
    }

    public List<MyERP_mainboard> boardlist(){
        return mainMapper.boardlist();
    }
}
