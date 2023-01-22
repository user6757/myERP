package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_userDTO;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    boolean singIn(MyERP_userDTO userDTO, HttpServletRequest request);

}
