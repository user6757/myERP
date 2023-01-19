package com.BEJproject.myERP.mapper;

import com.BEJproject.myERP.dto.MyERP_mainboard;
import com.BEJproject.myERP.dto.MyERP_userDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainBoardMapper {

    MyERP_userDTO getUser(String userId);

    boolean boardsave(MyERP_mainboard myERP_mainboard);

    List<MyERP_mainboard> boardlist();

    MyERP_mainboard getboard(String mainboardBno);

    boolean updateViewcnt(String mainboardBno);

    boolean boardmodify(MyERP_mainboard mainboard);

}
