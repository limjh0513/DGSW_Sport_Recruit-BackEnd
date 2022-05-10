package dgsw.hs.kr.dgsw_transfer.service;

import dgsw.hs.kr.dgsw_transfer.exception.CustomException;
import dgsw.hs.kr.dgsw_transfer.model.Post;
import dgsw.hs.kr.dgsw_transfer.model.Users;
import dgsw.hs.kr.dgsw_transfer.repository.PostRepository;
import dgsw.hs.kr.dgsw_transfer.repository.UserRepository;
import dgsw.hs.kr.dgsw_transfer.request.WriteRequest;
import dgsw.hs.kr.dgsw_transfer.response.AllPostResponse;
import dgsw.hs.kr.dgsw_transfer.response.DetailPostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;
    private final UserRepository userRepository;

    public Boolean writePost(WriteRequest request) throws CustomException {
        try {
            Post entity = new Post(request);
            repository.save(entity);
            return true;
        } catch (Exception e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "게시글 작성 실패...");
        }
    }

    public List<AllPostResponse> getAllPost() {
        updateAutoPostState();

        List<Post> entities = repository.findAll();
        ArrayList<AllPostResponse> responses = new ArrayList<>();

        entities.forEach(it -> {
            responses.add(getResponses(it));
        });

        return responses;
    }

    public List<AllPostResponse> getCategoryPost(int category) {
        List<Post> entities = repository.findAllByCategory(category).get();
        ArrayList<AllPostResponse> responses = new ArrayList<>();

        entities.forEach(it -> {
            responses.add(getResponses(it));
        });

        return responses;
    }

    public List<AllPostResponse> getStatePost(int state) {
        List<Post> entities = repository.findAllByState(state).get();
        ArrayList<AllPostResponse> responses = new ArrayList<>();

        entities.forEach(it -> {
            responses.add(getResponses(it));
        });

        return responses;
    }

    public List<AllPostResponse> getMyPost(int userIdx) throws CustomException {
        List<Post> entities;
        try {
            entities = repository.findAllByWritter(userIdx).get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(HttpStatus.NOT_FOUND, "유저 정보를 찾지 못햇습니다.");
        }

        ArrayList<AllPostResponse> responses = new ArrayList<>();

        entities.forEach(it -> {
            responses.add(getResponses(it));
        });

        return responses;
    }

    public DetailPostResponse getDetail(int postIdx) {
        Post entity = repository.getById(postIdx);
        Users users = userRepository.getById(entity.getWritter());

        DetailPostResponse response = new DetailPostResponse();

        response.setIdx(entity.getIdx());
        response.setTitle(entity.getTitle());
        response.setContent(entity.getContent());
        response.setPersonal(entity.getPersonnel());
        response.setCurrentPersonal(entity.getCurrentPersonnel());
        if (entity.getAnonymous() > 0) {
            response.setWritter("익명");
            response.setWritterImage("");
        } else {
            response.setWritter(users.getName());
            response.setWritterImage(users.getImage());
        }
        response.setPlace(entity.getPlace());
        response.setTime(entity.getTime());
        response.setCategory(entity.getCategory());
        response.setState(entity.getState());
        response.setHidden(entity.getHidden());

        return response;
    }

    //@Scheduled(fixedDelay = 300000)
    private void updateAutoPostState() {
        List<Post> entities = repository.findAll();
        String nowStr = LocalDateTime.now().toString();
        Timestamp now = Timestamp.valueOf(nowStr.substring(0, 10) + " " + nowStr.substring(11, 19));

        entities.forEach(it -> {
            Timestamp parseTime = new Timestamp(it.getTime().getTime() - 32400000);

            if (now.after(parseTime)) {
                it.setState(2);
                repository.save(it);
            } else {
                if (parseTime.getTime() - now.getTime() < 10800000) {
                    it.setState(1);
                    repository.save(it);
                }
            }
        });
    }

    private AllPostResponse getResponses(Post it) {
        Users user = userRepository.findById(it.getWritter()).get();
        AllPostResponse response = new AllPostResponse();
        response.setIdx(it.getIdx());
        response.setTitle(it.getTitle());
        response.setContent(it.getContent());
        response.setPersonal(it.getPersonnel());
        response.setCurrentPersonal(it.getCurrentPersonnel());
        if (it.getAnonymous() <= 0) {
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