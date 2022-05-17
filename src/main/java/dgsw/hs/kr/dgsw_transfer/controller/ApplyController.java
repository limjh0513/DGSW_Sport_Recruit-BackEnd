package dgsw.hs.kr.dgsw_transfer.controller;

import dgsw.hs.kr.dgsw_transfer.exception.CustomException;
import dgsw.hs.kr.dgsw_transfer.request.ApplyRequest;
import dgsw.hs.kr.dgsw_transfer.response.ApplyResponse;
import dgsw.hs.kr.dgsw_transfer.response.BaseResponse;
import dgsw.hs.kr.dgsw_transfer.response.MyApplyResponse;
import dgsw.hs.kr.dgsw_transfer.service.ApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apply")
public class ApplyController {
    final private ApplyService service;

    @GetMapping("/get/{idx}")
    public BaseResponse<List<ApplyResponse>> getApply(@PathVariable int idx) throws CustomException {
        List<ApplyResponse> responses = service.getApplyResponse(idx);
        return new BaseResponse<>(200, "신청 목록 조회 성공!", responses);
    }

    @GetMapping("/get/my/{userIdx}")
    public BaseResponse<List<ApplyResponse>> getMyApply(@PathVariable int userIdx) throws CustomException {
        List<ApplyResponse> responses = service.getMyApply(userIdx);
        return new BaseResponse<>(200, "내 신청 목록 조회 성공!", responses);
    }

    @GetMapping("/get/{postIdx}/{userIdx}")
    public BaseResponse<MyApplyResponse> getPostMyApply(@PathVariable int postIdx, @PathVariable int userIdx) throws CustomException {
        MyApplyResponse response = service.getPostMyApply(postIdx, userIdx);
        return new BaseResponse<>(200, "현재 게시글의 내 신청 조회 성공!", response);
    }

    @PostMapping("/post")
    public BaseResponse<Boolean> postApply(@RequestBody ApplyRequest request) throws CustomException {
        Boolean result = service.postApply(request);
        return new BaseResponse<>(200, "신청 완료!", result);
    }

    @PutMapping("/put/${applyIdx}/${state}")
    public BaseResponse<Integer> putApply(@PathVariable int applyIdx, @PathVariable int state) throws CustomException {
        Integer result = service.putApply(applyIdx, state);
        return new BaseResponse<>(200, "신청 상태 변경 완료", result);
    }
}
