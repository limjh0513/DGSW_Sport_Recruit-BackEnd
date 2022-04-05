package dgsw.hs.kr.dgsw_transfer.controller;

import dgsw.hs.kr.dgsw_transfer.exception.CustomException;
import dgsw.hs.kr.dgsw_transfer.request.LoginRequest;
import dgsw.hs.kr.dgsw_transfer.request.RegisterRequest;
import dgsw.hs.kr.dgsw_transfer.response.BaseResponse;
import dgsw.hs.kr.dgsw_transfer.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    final private AuthService service;

    @PostMapping("/login")
    public BaseResponse<Integer> login(@RequestBody LoginRequest request) throws CustomException{
        Integer userIdx = service.login(request);
        return new BaseResponse<>(200, "로그인 성공", userIdx);
    }

    @PostMapping("/register")
    public BaseResponse<Integer> register(@RequestBody RegisterRequest request) throws CustomException {
        int userIdx = service.register(request);
        return new BaseResponse<>(200, "회원가입 성공", userIdx);
    }
}
