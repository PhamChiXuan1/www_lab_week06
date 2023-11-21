package vn.edu.iuh.fit.backend.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Post;
import vn.edu.iuh.fit.backend.repositories.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public void addPost(Post post){
        try {
            postRepository.save(post);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }
    public Optional<Post> findById(long id){
        return postRepository.findById(id);
    }
    public Page<Post> findPaginated(int pageNo, int pageSize, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return postRepository.findAll(pageable);
    }
}
