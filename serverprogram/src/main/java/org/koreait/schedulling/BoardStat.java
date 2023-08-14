package org.koreait.schedulling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BoardStat {
    @Scheduled(cron="0 0 01 * * ?")//매일 새벽 1시에 실행
    public void schedule(){
        //Group by로 jdbcTemplate을 묶으려 했으나
        //mysql 오류 문제로 시도하지 못했습니다.
        System.out.println("1시에 실행");
    }
}
