package com.twinkle.JakSim.controller.review;

import com.twinkle.JakSim.model.dto.review.ReviewDto;
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
    public int registerReview(@PathVariable("tid") String tid, @AuthenticationPrincipal User user, @RequestBody ReviewDto dto){
        return reviewService.insertReview(tid, dto, user.getUsername());
    }

    @DeleteMapping("/delete/{r_idx}")
    public int deleteReview(@PathVariable("r_idx") int r_idx){
        return reviewService.deleteReview(r_idx);
    }

    @PutMapping("/modify/{r_idx}")
    public int mondifyReview(@PathVariable("r_idx") int r_idx, @RequestBody ReviewDto dto){
        return reviewService.updateReview(r_idx, dto);
    }


}
