package org.koreait.models.board;

public class BoardDataNotFoundException extends RuntimeException {
    public BoardDataNotFoundException() {
        super("등록 되지 않은 게시물입니다.");
    }
}
