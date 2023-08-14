package org.koreait.models.board;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class BoardData {//db에 저장 되어 있는 컬럼명
    private long id;
    private String poster;
    private String subject;
    private String content;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}