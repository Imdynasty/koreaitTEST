package org.koreait.models.board;

import lombok.RequiredArgsConstructor;
import org.koreait.controllers.board.DataForm;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Repository
@RequiredArgsConstructor
public class BoardDataDao {//data 저장소


   private final JdbcTemplate jdbcTemplate;

   //Mysql 에 데이터 저장하는 쿼리 오류로 인해 임시로 true
    public boolean save(DataForm data){
        return true;
    }
    //저장데이터가 없으므로 조회가 안되어 게시물 등록되지 않은 예외 조항 발생할 것
    public BoardData get(long id) {
        try {
            String sql = "SELECT * FROM BOARD_DATA WHERE ID = ?";
            BoardData data = jdbcTemplate.queryForObject(sql, this::mapper, id);
            return data;
        } catch (Exception e) {
            return null;
        }
    }

    public BoardData mapper(ResultSet rs, int i) throws SQLException {
        Timestamp modDt = rs.getTimestamp("MODDT");
        return BoardData.builder()
                .id(rs.getLong("ID"))
                .poster(rs.getString("POSTER"))
                .subject(rs.getString("SUBJECT"))
                .content(rs.getString("CONTENT"))
                .regDt(rs.getTimestamp("REGDT").toLocalDateTime())
                .modDt(modDt == null ? null : modDt.toLocalDateTime())
                .build();
    }

}
