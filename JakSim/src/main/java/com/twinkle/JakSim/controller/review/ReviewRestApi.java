package com.twinkle.JakSim.controller.review;

import com.twinkle.JakSim.model.dto.review.ReviewRequestDto;
import com.twinkle.JakSim.model.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review/api")
public class ReviewRestApi {
    private final ReviewService reviewService;
    @PostMapping("/register/{tid}")
    public int registerReview(@PathVariable("tid") int tid, @AuthenticationPrincipal User user, ReviewRequestDto dto){
        reviewService.insertReview(dto, user.getUsername());
        return 0;
    }

    @PutMapping("/modify/{r_dix}")
    public int modifyReview(@PathVariable("r_idx") int r_idx, @AuthenticationPrincipal User user, ReviewRequestDto dto){
        return 0;
    }

    @DeleteMapping("/delete/{r_idx}")
    public int deleteReview(@PathVariable("r_idx") int r_idx, @AuthenticationPrincipal User user){
        return 0;
    }


}
