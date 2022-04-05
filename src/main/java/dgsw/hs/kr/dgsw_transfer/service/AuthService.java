package dgsw.hs.kr.dgsw_transfer.service;

import dgsw.hs.kr.dgsw_transfer.exception.CustomException;
import dgsw.hs.kr.dgsw_transfer.model.UserEntity;
import dgsw.hs.kr.dgsw_transfer.repository.AuthRepository;
import dgsw.hs.kr.dgsw_transfer.request.LoginRequest;
import dgsw.hs.kr.dgsw_transfer.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    static AuthRepository repository;

    public Integer login(LoginRequest request) throws CustomException {
        UserEntity entity;
        try{
            entity = repository.findByUserId(request.getId()).get();
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException(HttpStatus.NOT_FOUND, "아이디가 존재하지 않습니다.");
        }

        if(entity.getPw().equals(request.getPw())){
            return entity.getUserIdx();
        } else {
            throw new CustomException(HttpStatus.NOT_FOUND, "비밀번호가 일치하지 않습니다.");
        }
    }

    public Integer register(RegisterRequest request) throws CustomException {
        UserEntity entity = new UserEntity(request.getId(), request.getPassword(), request.getGrade(), request.getRoom(), request.getNumber(), request.getName(), request.getProfileImage());
        try {
            repository.save(entity);
        } catch (Exception e) {
            throw new CustomException(HttpStatus.CONFLICT, "이미 가입 된 아이디가 있습니다.");
        }

        Optional<UserEntity> saveUser = repository.findByUserId(request.getId());
        return saveUser.get().getUserIdx();
    }
}
