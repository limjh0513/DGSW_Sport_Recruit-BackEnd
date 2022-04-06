package dgsw.hs.kr.dgsw_transfer.repository;

import dgsw.hs.kr.dgsw_transfer.model.PostEntity;
import dgsw.hs.kr.dgsw_transfer.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    Optional<List<PostEntity>> findAllByCategory(int category);
    Optional<List<PostEntity>> findAllByState(int state);
    Optional<List<PostEntity>> findAllByWritter(int writter);
}
