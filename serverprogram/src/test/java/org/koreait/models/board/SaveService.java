package org.koreait.models.board;

import lombok.RequiredArgsConstructor;
import org.koreait.controllers.board.DataForm;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveService {//저장 기능

    private final SaveValidator svalidator;
    public void save(DataForm df){

    }
}
