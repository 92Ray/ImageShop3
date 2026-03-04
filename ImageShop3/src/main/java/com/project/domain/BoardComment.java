package com.project.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BoardComment {
    private Long commentNo;
    private Long boardNo;
    private Long userNo;
    private String content;
    private Date regDate;
    private Date updDate;

    private String userName; // 작성자 이름
}