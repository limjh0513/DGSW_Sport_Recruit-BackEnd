package dgsw.hs.kr.dgsw_transfer.controller;

import dgsw.hs.kr.dgsw_transfer.exception.CustomException;
import dgsw.hs.kr.dgsw_transfer.request.WriteRequest;
import dgsw.hs.kr.dgsw_transfer.response.BaseResponse;
import dgsw.hs.kr.dgsw_transfer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
