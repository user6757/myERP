package com.BEJproject.myERP.mapper;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {

    MyERP_userDTO getUser(String userId);

}
