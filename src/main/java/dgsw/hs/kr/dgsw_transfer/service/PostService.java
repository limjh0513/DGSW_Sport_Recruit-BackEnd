package dgsw.hs.kr.dgsw_transfer.service;

import dgsw.hs.kr.dgsw_transfer.exception.CustomException;
import dgsw.hs.kr.dgsw_transfer.model.PostEntity;
import dgsw.hs.kr.dgsw_transfer.repository.PostRepository;
import dgsw.hs.kr.dgsw_transfer.request.WriteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    static PostRepository repository;

    public Boolean writePost(WriteRequest request) throws CustomException {
        try {
            PostEntity entity = new PostEntity(request);
            repository.save(entity);
            return true;
        } catch (Exception e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "게시글 작성 실패...");
        }
    }
}
