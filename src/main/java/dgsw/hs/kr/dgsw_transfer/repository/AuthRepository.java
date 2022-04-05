package dgsw.hs.kr.dgsw_transfer.repository;

import dgsw.hs.kr.dgsw_transfer.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUserId(String userId);
}
