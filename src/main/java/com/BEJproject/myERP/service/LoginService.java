package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_userDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoginService {

    boolean singIn(MyERP_userDTO userDTO, HttpServletRequest request) throws Exception;
    int accountfind(MyERP_userDTO myERP_userDTO);

    List<MyERP_userDTO> getaccount(MyERP_userDTO myERP_userDTO);

}
