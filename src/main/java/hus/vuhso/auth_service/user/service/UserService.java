package hus.vuhso.auth_service.user.service;

import hus.vuhso.auth_service.model.User;
import hus.vuhso.auth_service.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    private Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
