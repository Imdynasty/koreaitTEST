package org.koreait.models.board;


//Runtime오류시 오류메시지 발생_예외
public class BoardValidationException extends RuntimeException{
    public BoardValidationException(String msg){
        super(msg);
    }
}
