package dgsw.hs.kr.dgsw_transfer.service;

import dgsw.hs.kr.dgsw_transfer.exception.CustomException;
import dgsw.hs.kr.dgsw_transfer.model.UserEntity;
import dgsw.hs.kr.dgsw_transfer.repository.UserRepository;
import dgsw.hs.kr.dgsw_transfer.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    final UserRepository repository;

    public UserResponse inquireUser(Integer userIdx) throws CustomException {
        try {
            UserEntity entity = repository.findById(userIdx).get();
            UserResponse response = new UserResponse(entity.getGrade(), entity.getRoom(), entity.getNumber(), entity.getName(), entity.getImage());
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(HttpStatus.NOT_FOUND, "존재하지 않는 유저 IDX 입니다.");
        }
    }
}
