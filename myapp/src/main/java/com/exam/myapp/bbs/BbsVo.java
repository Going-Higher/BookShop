package com.exam.myapp.bbs;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.exam.myapp.attach.AttachVo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BbsVo {
    private int bbsNo;
    private String bbsTitle;
    private String bbsContent;
    private String bbsWriter;
    private Date bbsReqDate;
    private int bbsCount; 
    //폼 데이터에 포함된 파일은 MultipartFile 타입 변수로 받을 수 있다
    private List<MultipartFile> upfileList;
    
    private List<AttachVo> attList;
}
