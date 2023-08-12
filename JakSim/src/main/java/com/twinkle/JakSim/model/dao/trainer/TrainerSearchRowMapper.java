package com.twinkle.JakSim.model.dao.trainer;

import com.twinkle.JakSim.model.dto.trainer.TrainerSearchDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerSearchRowMapper implements RowMapper<TrainerSearchDto> {
    @Override
    public TrainerSearchDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        TrainerSearchDto trainerSearchDto = new TrainerSearchDto();

        trainerSearchDto.setTrainerId(rs.getInt("UT_IDX"));
        trainerSearchDto.setUserName(rs.getString("USER_NAME"));
        trainerSearchDto.setUserId(rs.getString("USER_ID"));
        trainerSearchDto.setAddress(rs.getString("UT_ADDRESS"));
        trainerSearchDto.setProfile(rs.getString("UT_PROFILE_IMG"));

        trainerSearchDto.setGym(rs.getString("UT_GYM"));
        trainerSearchDto.setExpert1(rs.getInt("UT_EXPERT_1"));
        trainerSearchDto.setExpert2(rs.getInt("UT_EXPERT_2"));

        trainerSearchDto.setCertName(rs.getString("TC_NAME"));  //자격증이 여러 개가 들어올 수 있는데, 어떻게 되는건지?
        //검색 간에 자격증 정보를 가지고 검색하거나 자격증정보를 내놓는 부분이 없는데 필요한 컬럼인지?
        trainerSearchDto.setImagePath(rs.getString("TI_PATH")); //프로필 컬럼을 따로 만들었는데, 이 컬럼은 무슨 의미를 지니는지?

        return trainerSearchDto;
    }
}
