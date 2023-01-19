package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_mainboard;
import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.mapper.MainBoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class MainBoardServiceImpl implements MainBoardService {

    private MainBoardMapper mainBoardMapper;

    @Autowired
    public MainBoardServiceImpl(MainBoardMapper mainBoardMapper){
        this.mainBoardMapper = mainBoardMapper;
    }

    public MyERP_userDTO getUser(String userId){
        return mainBoardMapper.getUser(userId);
    }

    public boolean boardsave(MyERP_mainboard myERP_mainboard){
        return mainBoardMapper.boardsave(myERP_mainboard);
    }

    private String regdate(Date date){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String regdate = dateFormat.format(date);
        return regdate;
    }

    public List<MyERP_mainboard> boardlist(){

        List<MyERP_mainboard> list = mainBoardMapper.boardlist();
        List<MyERP_mainboard> boardlist = new ArrayList<>();

        for (MyERP_mainboard main: list){
            main.setStrRegdate(regdate(main.getMainboardRegdate()));
            boardlist.add(main);
        }

        return boardlist;
    }

    @Override
    public MyERP_mainboard getboard(String mainboardBno) {

        boolean cnt = mainBoardMapper.updateViewcnt(mainboardBno);
        if (cnt == true){
            MyERP_mainboard mainboard = mainBoardMapper.getboard(mainboardBno);
            mainboard.setStrRegdate(regdate(mainboard.getMainboardRegdate()));
            return mainboard;
        }else{
            return null;
        }
    }

    @Override
    public boolean boardmodify(MyERP_mainboard mainboard) {
        return mainBoardMapper.boardmodify(mainboard);
    }
}
