package dgsw.hs.kr.dgsw_transfer.repository;

import dgsw.hs.kr.dgsw_transfer.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
}
