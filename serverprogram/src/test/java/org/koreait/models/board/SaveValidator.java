package org.koreait.models.board;

import org.koreait.controllers.board.DataForm;
import org.koreait.validators.RequiredValidator;
import org.koreait.validators.Validator;

public class SaveValidator implements Validator<DataForm>, RequiredValidator {
    @Override
    public void check(DataForm dataForm) {
        //작성자가 입력한 정보 중 공백이거나 없을 경우 message 호출하는 예외 발생.
        checkRequired(dataForm.getPoster(), new BoardValidationException("작성자 필수 입력."));
        checkRequired(dataForm.getSubject(), new BoardValidationException("제목 필수 입력."));
        checkRequired(dataForm.getContent(), new BoardValidationException("내용 필수 입력."));
    }
}
