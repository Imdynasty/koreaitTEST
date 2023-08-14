package org.koreait.controllers.board;

import lombok.Data;

@Data
public class DataForm {//사용자가 입력할 수 있는 게시판 항목 형태
    private long id;
    private String poster;
    private String subject;
    private String content;
}
