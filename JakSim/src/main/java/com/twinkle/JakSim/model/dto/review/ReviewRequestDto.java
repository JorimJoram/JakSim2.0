package com.twinkle.JakSim.model.dto.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDto {
    private int reviewIdx;
    private String userId;
    private int payment_idx;
    private String content;
    private int star;
    private String reviewCreateDate;
    private String reviewModifyDate;
    private double avgRstar;
    private int reviewCnt;

}
