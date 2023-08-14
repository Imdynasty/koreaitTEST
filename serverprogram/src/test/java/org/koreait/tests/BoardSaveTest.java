package org.koreait.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.koreait.controllers.board.DataForm;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("WholeTest_BoardSaveService")
public class BoardSaveTest {

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
}
