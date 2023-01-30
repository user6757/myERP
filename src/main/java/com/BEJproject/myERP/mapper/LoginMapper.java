package com.BEJproject.myERP.mapper;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {

    int singIn(MyERP_userDTO myERPuserDTO);
    int accountfind(MyERP_userDTO myERP_userDTO);

    List<MyERP_userDTO> getaccount(MyERP_userDTO myERP_userDTO);

    int pwfind(String userId);

}
