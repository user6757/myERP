package com.BEJproject.myERP.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    private String userId;   //사원 아이디
    private String userPw;   //사원 비밀번호
    private String userName;  //사원 이름
    private String userTel;    //사원 전화번호
    private Date userRegdate; //등록날짜
    private Date userModifyregdate; //사원정보수정날짜
    private Integer userNo; //사원번호
    private String userFlag; //사원구분

}
