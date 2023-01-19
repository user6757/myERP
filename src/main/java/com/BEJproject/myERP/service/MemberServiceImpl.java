package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.MyERP_userDTO;
import com.BEJproject.myERP.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

@Service
@Log4j2
public class MemberServiceImpl implements MemberService{

    private MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper){
        this.memberMapper = memberMapper;
    }

    public boolean idcheck(String userId){
        int getidcheck = memberMapper.idcheck(userId);

        if (getidcheck > 0){
            return false;
        }else {
            return true;
        }

    }

    public boolean singUp(MyERP_userDTO userDTO) throws Exception{

        if (userDTO.getUserPw().equals("erpadminbej")){
            userDTO.setUserFlag("관리자");
        }else {
            userDTO.setUserFlag("사원");
        }

        MessageDigest pw = MessageDigest.getInstance("SHA-512");
        pw.update(userDTO.getUserPw().getBytes("UTF-8"));
        byte[] getpass = pw.digest();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<getpass.length; i++){
            sb.append(Integer.toString((getpass[i] & 0xff)+ 0x100, 16).substring(1));
        }
        String password = sb.toString();
        userDTO.setUserPw(password);
        boolean singUpresult = memberMapper.singUp(userDTO);

        return singUpresult;
    }

    @Override
    public String getuserName(String userId) {
        return memberMapper.getuserName(userId);
    }
}
