package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.models.PostComment;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    List<PostComment> findAllByPostId(@Param("postId") Long postId);
}
