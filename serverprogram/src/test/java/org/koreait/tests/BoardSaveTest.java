package org.koreait.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.controllers.board.DataForm;
import org.koreait.models.board.BoardData;
import org.koreait.models.board.InfoService;
import org.koreait.models.board.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("WholeTest_BoardSaveService")
public class BoardSaveTest {

    @Autowired
    private InfoService infoService;
    @Autowired
    private SaveService saveService;
    private DataForm boardData;

    @BeforeEach
    void init() {
        boardData = getData();
    }

    private DataForm getData() {
        DataForm boardData = new DataForm();
        boardData.setPoster("작성자");
        boardData.setSubject("제목");
        boardData.setContent("내용");

        return boardData;
    }

    @Test
    @DisplayName("게시글 등록 or 수정 성공시 예외가 발생 하지 않음")
    void saveSuccessTest() {
        assertDoesNotThrow(() -> {//에러가 발생하지않으면 true
            saveService.save(boardData);
        });
    }
    @Test
    @DisplayName("저장전후 데이터 검증")
    void saveResultTest() {
        saveService.save(boardData);
        BoardData result = infoService.get(boardData.getId());
        assertAll(
                () -> assertEquals(boardData.getPoster(), result.getPoster()),
                () -> assertEquals(boardData.getSubject(), result.getSubject()),
                () -> assertEquals(boardData.getContent(), result.getContent())
        );
    }


}
