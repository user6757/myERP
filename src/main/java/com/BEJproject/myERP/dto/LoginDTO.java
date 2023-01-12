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
    private Date userModifyregdate;
    private Integer userNo; //사원번호                  ((중요!!   db값을 varcahr에서 long으로 변환 따라서 사원번호String에서 Integet로 변환))
    private String userFlag; //사원구분

}
