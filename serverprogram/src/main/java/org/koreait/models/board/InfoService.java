package org.koreait.models.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoService {//정보 추출 서비스
    private final BoardDataDao dataDao;

    public BoardData get(long id)  {//id값이 없다면 등록된 게시물이 없는 예외  발생

        BoardData data = dataDao.get(id);
        if (data == null) {
            throw new BoardDataNotFoundException();
        }

        return data;
    }
}
