package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class LoginServiceImpl implements LoginService{

    private LoginMapper loginMapper;
    private HttpSession session;

    @Autowired
    public LoginServiceImpl(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    public boolean singIn(MyERP_userDTO myERPuserDTO, HttpServletRequest request) throws Exception{

        MessageDigest pw = MessageDigest.getInstance("SHA-512");
        pw.update(myERPuserDTO.getUserPw().getBytes("UTF-8"));
        byte[] getpassword = pw.digest();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<getpassword.length; i++){
            sb.append(Integer.toString((getpassword[i] & 0xff)+ 0x100, 16).substring(1));
        }
        String password = sb.toString();
        myERPuserDTO.setUserPw(password);

        int getuser = loginMapper.singIn(myERPuserDTO);

        boolean pathreult = true;
        if (getuser > 0){

            session = request.getSession();
            session.setAttribute("userId", myERPuserDTO.getUserId());
            session.setMaxInactiveInterval(18000);                                      //세션유지 5시간 설정
            return pathreult;
        }else{

            return pathreult = false;
        }

    }

    @Override
    public int accountfind(MyERP_userDTO myERP_userDTO) {
        return loginMapper.accountfind(myERP_userDTO);
    }

    @Override
    public List<MyERP_userDTO> getaccount(MyERP_userDTO myERP_userDTO) {

        List<MyERP_userDTO> userlist = loginMapper.getaccount(myERP_userDTO);

        for (int i=0; i<userlist.size(); i++){

            MyERP_userDTO users = userlist.get(i);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String joindate = dateFormat.format(users.getUserRegdate());
            users.setStruserRegdate(joindate);
            userlist.set(i,users);

        }

        return userlist;
    }

}
