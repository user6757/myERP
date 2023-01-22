package com.BEJproject.myERP.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyERP_mainboard {

    private Integer mainboardBno;
    private String mainboardTitle;
    private String mainboardWriter;
    private String mainboardContent;
    private Integer mainboardViewcnt;
    private String mainboardUserId;
    private Date mainboardRegdate;
    private Date mainboardModifyRegdate;
    private String strRegdate;
    private String strModifiyRegdate;
}
