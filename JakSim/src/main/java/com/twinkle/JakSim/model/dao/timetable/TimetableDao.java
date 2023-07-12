package com.twinkle.JakSim.model.dao.timetable;

import com.twinkle.JakSim.model.dto.timetable.response.TimetableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TimetableDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public Boolean isTimetable(int tIdx) {
        Boolean result = true;

        this.sql = "select * from timetable where t_idx = ?";

        try {
            jdbcTemplate.queryForObject(this.sql, new TimetableRowMapper(), tIdx);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("there isn't any timetables");
            System.out.println(e);

            result = false;
        } catch (Exception e){
            System.out.println(e);
        }

        return result;
    }

    public List<TimetableDto> findAllTimetable(String userId) {
        List<TimetableDto> timetableDtoList = new ArrayList<>();

        this.sql = "select * from timetable as tt inner join trainer_details as td on tt.ut_idx = td.ut_idx" +
                " where user_id = ?";

        try {
            timetableDtoList = jdbcTemplate.query(this.sql, new TimetableRowMapper(), userId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("there isn't any timetables");
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        }

        return timetableDtoList;
    }

    public Optional<TimetableDto> findMyTimetableRecent(String username) {
        String sql = "SELECT * FROM TIMETABLE WHERE USER_ID = ? LIMIT 1";
        TimetableDto timetableDto = null;

        try{
            timetableDto = jdbcTemplate.queryForObject(sql, new TimetableRowMapper(), username);
        }catch (Exception e){
            System.out.println("Dao: " + e.getMessage());
        }

        return Optional.ofNullable(timetableDto);
    }

    public Optional<List<TimetableDto>> findMyTimetableSoon(String username) {
        String sql = "select T_IDX, USER_ID, T_DATE, T_START_T, T_END_T, T_PEOPLE, T_TYPE, (T_DATE - CURRENT_DATE) AS DIFFDATE, (T_START_T - CURRENT_TIME) AS DIFFTIME " +
                "from timetable " +
                "where (t_date - current_date) >=0 and user_id = ? " +
                "order by DIFFDATE asc, DIFFTIME desc " +
                "LIMIT 5";
        List<TimetableDto> timeList = new ArrayList<>();

        try{
            timeList = jdbcTemplate.query(sql, new TimetableRowMapper(), username);
        }catch (Exception e){
            System.out.println("Soon dao: " + e.getMessage());
        }

        return Optional.ofNullable(timeList);
    }
}
