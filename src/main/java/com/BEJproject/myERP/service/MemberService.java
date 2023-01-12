package com.BEJproject.myERP.service;

import com.BEJproject.myERP.dto.LoginDTO;
import com.BEJproject.myERP.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public boolean idcheck(String userId){
        int getidcheck = memberMapper.idcheck(userId);
        log.info("조회결과:{}", getidcheck);
        if (getidcheck > 0){
            return false;
        }else {
            return true;
        }

    }

    public boolean singUp(LoginDTO loginDTO) {
        if (loginDTO.getUserPw().equals("erpadminbej")){
            loginDTO.setUserFlag("관리자");
        }else {
            loginDTO.setUserFlag("사원");
        }
        boolean singUpresult = memberMapper.singUp(loginDTO);
        log.info("받은 결과:{}", singUpresult);
        return singUpresult;
    }
}
