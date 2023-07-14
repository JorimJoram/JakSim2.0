package com.twinkle.JakSim.model.service.payment;

import com.twinkle.JakSim.model.dao.payment.PaymentDao;
import com.twinkle.JakSim.model.dto.payment.PaymentDo;
import com.twinkle.JakSim.model.dto.product.response.ValidPtDto;
import com.twinkle.JakSim.model.dto.trainer.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentDao paymentDao;

    public List<ValidPtDto> findValidPtList(String userId) {
        List<ValidPtDto> list = new ArrayList<>();
        LocalDate today = LocalDate.now();

        try {
            list = paymentDao.findAllValidPt(userId, today);
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    public Optional<PaymentDo> getRecentPayment(String username) {
        return paymentDao.findRecentByUsername(username);
    }

    /**
     * <p>한 페이지 당 3개의 아이템이 보여진다고 가정하고 진행</p>
     * <p>페이지 당 보여지는 결제 개수는 pageSize에서 설정</p>
     * @param username 사용자 아이디
     * @return 전체 개수에서 페이지 사이즈 만큼 나눈 후 + 1
     */
    public Object getTotalPage(String username) {
        int pageSize = 10;
        return (paymentDao.getTotalPage(username) / pageSize) + 1;
    }

    /**
     * 테스트를 위해서는 어쩔 수 없었습니다;;
     * @param username 사용자 아이디
     * @param page 몇 번째 페이지인지
     * @return 요청에 맞춘 데이터
     */
    public List<PaymentDo> getPageItem(String username, int page) {
        int pageSize = 10;
        return paymentDao.getRecentByPage(username, page, pageSize);
    }


    public Optional<PaymentDo> getPaymentByIdx(int pIdx) {
        return paymentDao.getPaymentByIdx(pIdx);
    }

    public ProductDto getProductByIdx(int tpIdx) {
        return paymentDao.getProductByIdx(tpIdx);
    }
}
