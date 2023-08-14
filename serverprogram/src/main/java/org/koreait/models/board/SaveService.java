package org.koreait.models.board;

import lombok.RequiredArgsConstructor;
import org.koreait.controllers.board.DataForm;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveService {//저장 기능

    private final SaveValidator svalidator;
    private final BoardDataDao dataDao;
    public void save(DataForm df){//사용자가 입력한 정보가 검증이 완료되면 데이터 저장
        svalidator.check(df);

        dataDao.save(df);
    }
}
