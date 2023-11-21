package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.PostComment;

import java.util.List;

public interface PostCommentRepositories extends JpaRepository<PostComment, Long> {

}
