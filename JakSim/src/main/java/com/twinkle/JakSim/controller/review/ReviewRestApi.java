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
    public int registerReview(@PathVariable("tid") String tid, @AuthenticationPrincipal User user, @RequestBody ReviewRequestDto dto){
        System.out.println(dto.toString());
        return reviewService.insertReview(tid, dto, user.getUsername());
    }

    @PutMapping("/modify/{r_idx}")
    public int modifyReview(@PathVariable("r_idx") int r_idx, @AuthenticationPrincipal User user, ReviewRequestDto dto){
        return 0;
    }

    @DeleteMapping("/delete/{r_idx}")
    public int deleteReview(@PathVariable("r_idx") int r_idx, @AuthenticationPrincipal User user){
        return 0;
    }


}
