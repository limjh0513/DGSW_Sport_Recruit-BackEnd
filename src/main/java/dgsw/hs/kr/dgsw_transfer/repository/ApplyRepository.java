package dgsw.hs.kr.dgsw_transfer.repository;

import dgsw.hs.kr.dgsw_transfer.model.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Integer> {
    Optional<List<Apply>> findAllByPostIdx(int postIdx);
    Optional<List<Apply>> findAllByUserIdx(int userIdx);
    Optional<List<Apply>> findBy
}
