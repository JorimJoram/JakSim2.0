package com.twinkle.JakSim.model.service.review;

import com.twinkle.JakSim.model.dao.review.ReviewDao;
import com.twinkle.JakSim.model.dao.trainer.TrainerDao;
import com.twinkle.JakSim.model.dto.review.ReviewDto;
import com.twinkle.JakSim.model.dto.review.ReviewDto;
import com.twinkle.JakSim.model.dto.trainer.TrainerInsertDto;
import com.twinkle.JakSim.model.dto.trainer.TrainerSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewDao reviewDao;

    // 리뷰 등록
    @Transactional
    public int insertReview(String tid, ReviewDto dto, String userId) {
        return reviewDao.insertReview(tid, dto, userId);
    }

    @Transactional
    public int deleteReview(int r_idx) {
        return reviewDao.deleteReview(r_idx);
    }

    public int updateReview(int r_idx, ReviewDto dto) {
        return reviewDao.updateReview(r_idx, dto);
    }

    // 리뷰 수정하기
    @Transactional
    public void editReview(ReviewDto review, String userId) {
        reviewDao.editReview(review, userId);
    }

    // 리뷰 삭제하기


    // 트레이너별 리뷰 미리보기 (3개)
    @Transactional
    public List<ReviewDto> showReview(int trainerId) {
        return reviewDao.getTrainerReview(trainerId);
    }

    // 트레이너별 리뷰 전체보기
    @Transactional
    public List<ReviewDto> showReviewAll(int page, int pageSize, int filter, int trainerId) {
        return reviewDao.getTrainerReviewAll(page, pageSize, filter, trainerId);
    }

    // 리뷰 별점 및 총 갯수 count
    @Transactional
    public ReviewDto getStarAvgAndCnt(int trainerId) {
        return reviewDao.getStarAvgAndCnt(trainerId);
    }

    // 리뷰 가져오기 (리뷰 인덱스별)
    @Transactional
    public List<ReviewDto> showMyReview(String userId, int reviewIdx) {
        return reviewDao.getMyReview(userId, reviewIdx);
    }

    // 나의 리뷰 전체 가져오기 (마이페이지용) -> 본인이 직접 제작함 ㅎㅎ
    @Transactional
    public Optional<List<ReviewDto>> showMyReviewForMyPage(String userId) {
        return reviewDao.getMyReviewForMyPage(userId);
    }


}
