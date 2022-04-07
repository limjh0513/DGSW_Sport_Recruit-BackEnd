package dgsw.hs.kr.dgsw_transfer.repository;

import dgsw.hs.kr.dgsw_transfer.model.ApplyEntity;
import dgsw.hs.kr.dgsw_transfer.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplyRepository extends JpaRepository<ApplyEntity, Integer> {
    Optional<List<ApplyEntity>> findAllByPostIdx(int postIdx);
    Optional<List<ApplyEntity>> findAllByUserIdx(int userIdx);
}
