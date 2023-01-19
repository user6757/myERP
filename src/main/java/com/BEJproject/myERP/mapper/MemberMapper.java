package com.BEJproject.myERP.mapper;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    int idcheck(String userId);
    boolean singUp(MyERP_userDTO myERPuserDTO);

    String getuserName(String userId);

}
