package dgsw.hs.kr.dgsw_transfer.controller;

import dgsw.hs.kr.dgsw_transfer.exception.CustomException;
import dgsw.hs.kr.dgsw_transfer.response.BaseResponse;
import dgsw.hs.kr.dgsw_transfer.response.UserResponse;
import dgsw.hs.kr.dgsw_transfer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    final private UserService userService;

    @GetMapping("/inquire/{id}")
    public BaseResponse<UserResponse> inquireUser(@PathVariable int id) throws CustomException {
        UserResponse response = userService.inquireUser(id);
        return new BaseResponse<>(200, "유저 조회 성공!", response);
    }
}
