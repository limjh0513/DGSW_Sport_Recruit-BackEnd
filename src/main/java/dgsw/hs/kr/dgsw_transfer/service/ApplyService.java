package dgsw.hs.kr.dgsw_transfer.service;

import dgsw.hs.kr.dgsw_transfer.exception.CustomException;
import dgsw.hs.kr.dgsw_transfer.model.Apply;
import dgsw.hs.kr.dgsw_transfer.model.Post;
import dgsw.hs.kr.dgsw_transfer.repository.ApplyRepository;
import dgsw.hs.kr.dgsw_transfer.repository.PostRepository;
import dgsw.hs.kr.dgsw_transfer.request.ApplyRequest;
import dgsw.hs.kr.dgsw_transfer.response.ApplyResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ApplyService {
    private final ApplyRepository repository;
    private final PostRepository postRepository;

    public List<ApplyResponse> getApplyResponse(int idx) throws CustomException {
        try {
            List<Apply> entities = repository.findAllByPostIdx(idx).get();
            ArrayList<ApplyResponse> responses = new ArrayList<>();
            entities.forEach(it -> {
                ApplyResponse response = new ApplyResponse(it);
                responses.add(response);
            });

            return responses;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(HttpStatus.NOT_FOUND, "신청 목록 조회 중 문제가 발생했습니다.");
        }
    }

    public List<ApplyResponse> getMyApply(int userIdx) throws CustomException {
        try {
            List<Apply> entities = repository.findAllByUserIdx(userIdx).get();
            ArrayList<ApplyResponse> responses = new ArrayList<>();
            entities.forEach(it -> {
                ApplyResponse response = new ApplyResponse(it);
                responses.add(response);
            });

            return responses;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(HttpStatus.NOT_FOUND, "내 신청 목록 조회 중 문제가 발생했습니다.");
        }
    }

    public Boolean postApply(ApplyRequest request) throws CustomException {
        try {
            Apply entity = new Apply(request);
            repository.save(entity);
            Post post = postRepository.findById(request.getPostIdx()).get();
            post.setCurrentPersonnel(post.getCurrentPersonnel() + 1);
            postRepository.save(post);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(HttpStatus.BAD_REQUEST, "신청 중 문제가 발생했습니다.");
        }
    }
}
