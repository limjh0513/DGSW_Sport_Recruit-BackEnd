package dgsw.hs.kr.dgsw_transfer.service;

import dgsw.hs.kr.dgsw_transfer.exception.CustomException;
import dgsw.hs.kr.dgsw_transfer.model.PostEntity;
import dgsw.hs.kr.dgsw_transfer.model.UserEntity;
import dgsw.hs.kr.dgsw_transfer.repository.PostRepository;
import dgsw.hs.kr.dgsw_transfer.repository.UserRepository;
import dgsw.hs.kr.dgsw_transfer.request.WriteRequest;
import dgsw.hs.kr.dgsw_transfer.response.AllPostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    static PostRepository repository;
    static UserRepository userRepository;

    public Boolean writePost(WriteRequest request) throws CustomException {
        try {
            PostEntity entity = new PostEntity(request);
            repository.save(entity);
            return true;
        } catch (Exception e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "게시글 작성 실패...");
        }
    }

    public List<AllPostResponse> getAllPost() {
        List<PostEntity> entities = repository.findAll();
        ArrayList<AllPostResponse> responses = new ArrayList<>();

        entities.forEach(it -> {
            responses.add(getResponses(it));
        });

        return responses;
    }

    public List<AllPostResponse> getCategoryPost(int category) {
        List<PostEntity> entities = repository.findAllByCategory(category).get();
        ArrayList<AllPostResponse> responses = new ArrayList<>();

        entities.forEach(it -> {
            responses.add(getResponses(it));
        });

        return responses;
    }

    public List<AllPostResponse> getStatePost(int state){
        List<PostEntity> entities = repository.findAllByState(state).get();
        ArrayList<AllPostResponse> responses = new ArrayList<>();

        entities.forEach(it -> {
            responses.add(getResponses(it));
        });

        return responses;
    }

    public List<AllPostResponse> getMyPost(int userIdx) throws CustomException {
        List<PostEntity> entities;
        try{
            entities = repository.findAllByWritter(userIdx).get();
        } catch (Exception e){
            e.printStackTrace();
            throw new CustomException(HttpStatus.NOT_FOUND, "유저 정보를 찾지 못햇습니다.");
        }

        ArrayList<AllPostResponse> responses = new ArrayList<>();

        entities.forEach(it -> {
            responses.add(getResponses(it));
        });

        return responses;
    }

    private AllPostResponse getResponses(PostEntity it) {
        UserEntity user = userRepository.findById(it.getWritter()).get();
        AllPostResponse response = new AllPostResponse();
        response.setIdx(it.getIdx());
        response.setTitle(it.getTitle());
        response.setContent(it.getContent());
        response.setPersonal(it.getPersonal());
        response.setCurrentPersonal(it.getCurrentPersonal());
        if (it.getAnonymous() > 0) {
            response.setWritter(user.getName());
            response.setWritterImage(user.getImage());
        } else {
            response.setWritter(null);
            response.setWritterImage(null);
        }
        response.setCategory(it.getCategory());
        response.setTime(it.getTime());
        response.setState(it.getState());

        return response;
    }
}
