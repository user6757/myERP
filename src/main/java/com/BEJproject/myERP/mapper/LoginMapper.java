package com.BEJproject.myERP.mapper;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    int singIn(MyERP_userDTO myERPuserDTO);
}
