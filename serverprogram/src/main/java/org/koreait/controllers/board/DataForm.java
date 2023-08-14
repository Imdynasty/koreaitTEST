package org.koreait.controllers.board;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DataForm {//사용자가 입력할 수 있는 게시판 항목 형태
    private long id;
    //null이 아니고 최소한 한 개 이상의 공백아닌 문자를 포함하는지 검사한다.
    @NotBlank(message = "작성자 필수 입력.")
    private String poster;

    @NotBlank(message = "제목 필수 입력.")
    private String subject;

    @NotBlank(message = "내용 필수 입력.")
    private String content;
}
