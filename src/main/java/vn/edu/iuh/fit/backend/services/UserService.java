package vn.edu.iuh.fit.backend.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.repositories.UserRepository;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User login(String email, String password){
        return userRepository.findByEmailAndPasswordHash(email, password).orElse(null);
    }
    public User getUserById(long id){
        return userRepository.findById(id).orElse(null);
    }

    public boolean checkLogin(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user!=null){
            return user.getPasswordHash().equals(password);
        }
        return false;
    }
}
