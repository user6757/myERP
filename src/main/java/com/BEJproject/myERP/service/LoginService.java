package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_userDTO;

public interface LoginService {

    boolean singIn(MyERP_userDTO userDTO);

}
