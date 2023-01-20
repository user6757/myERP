package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_mainboard;
import com.BEJproject.myERP.dto.MyERP_userDTO;

import java.util.List;

public interface MainBoardService {

    MyERP_userDTO getUser(String userId);

    boolean boardsave(MyERP_mainboard myERP_mainboard);

    List<MyERP_mainboard> boardlist();

    MyERP_mainboard getboard(String mainboardBno);

    boolean boardmodify(MyERP_mainboard mainboard);

    boolean delete(int mainboardBno);


}
