package com.BEJproject.myERP.mapper;

import com.BEJproject.myERP.dto.LoginDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    int idcheck(String userId);
    boolean singUp(LoginDTO loginDTO);

}
