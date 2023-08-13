package com.twinkle.JakSim;

import com.twinkle.JakSim.model.dto.review.ReviewDto;
import com.twinkle.JakSim.model.service.review.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Review 관련 CUD 단위 테스트입니다.
 */
@SpringBootTest
public class ReviewRestApiTest {
    @Autowired
    private ReviewService reviewService;

    @Test
    void Create(){
        ReviewDto dto = new ReviewDto();
        dto.setContent("Test at Spring");
        dto.setStar(4);
        dto.setUserId("west5");
        dto.setTid("T4d69e2b76b90283a2d4");

        String result = (reviewService.insertReview(dto.getTid(), dto, dto.getUserId()) > 0) ? "success" : "fail";
        System.out.println(result);
    }

    @Test
    void Update(){
        ReviewDto dto = new ReviewDto();
        dto.setIdx(8);
        dto.setContent("TEster!@");
        dto.setStar(3);

        System.out.println(reviewService.updateReview(dto.getIdx(), dto));
    }

    @Test
    void Delete(){
        String result = (reviewService.deleteReview(5) > 0) ? "success" : "fail";
        System.out.println(result);
    }
}