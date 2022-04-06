package dgsw.hs.kr.dgsw_transfer.controller;

import dgsw.hs.kr.dgsw_transfer.exception.CustomException;
import dgsw.hs.kr.dgsw_transfer.model.PostEntity;
import dgsw.hs.kr.dgsw_transfer.repository.UserRepository;
import dgsw.hs.kr.dgsw_transfer.request.WriteRequest;
import dgsw.hs.kr.dgsw_transfer.response.AllPostResponse;
import dgsw.hs.kr.dgsw_transfer.response.BaseResponse;
import dgsw.hs.kr.dgsw_transfer.response.DetailPostResponse;
import dgsw.hs.kr.dgsw_transfer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    final private PostService postService;

    @PostMapping("/write")
    public BaseResponse<Boolean> writePost(@RequestBody WriteRequest request) throws CustomException {
        Boolean result = postService.writePost(request);
        return new BaseResponse<>(200, "게시글 작성 성공!", result);
    }

    @GetMapping("/all")
    public BaseResponse<List<AllPostResponse>> getAllPost() {
        List<AllPostResponse> responses = postService.getAllPost();
        return new BaseResponse<>(200, "게시글 전체 목록 조회 성공", responses);
    }

    @GetMapping("/category/{category}")
    public BaseResponse<List<AllPostResponse>> getCategoryPost(@PathVariable int category) {
        List<AllPostResponse> responses = postService.getCategoryPost(category);
        return new BaseResponse<>(200, "카테고리 별 게시글 조회 성공", responses);
    }

    @GetMapping("/state/{state}")
    public BaseResponse<List<AllPostResponse>> getStatePost(@PathVariable int state){
        List<AllPostResponse> responses = postService.getStatePost(state);
        return new BaseResponse<>(200, "긴급 게시글 조회 성공", responses);
    }

    @GetMapping("/detail/{postIdx}")
    public BaseResponse<DetailPostResponse> getDetailPost(@PathVariable int postIdx){

    }

    @GetMapping("/my/{userIdx}")
    public BaseResponse<List<AllPostResponse>> getMyPost(@PathVariable int userIdx) throws CustomException {
        List<AllPostResponse> responses = postService.getMyPost(userIdx);
        return new BaseResponse<>(200, "내가 작성한 게시글 조회 성공", responses);
    }

}
