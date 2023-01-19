package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_userDTO;

public interface MemberService {

    boolean idcheck(String userId);

    boolean singUp(MyERP_userDTO myERP_userDTO) throws Exception;

    String getuserName(String userId);
}
