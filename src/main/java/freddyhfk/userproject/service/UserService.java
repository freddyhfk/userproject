package freddyhfk.userproject.service;

import freddyhfk.userproject.entity.User;
import freddyhfk.userproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        boolean userExists = userRepository.findById(user.getId()).isPresent();
        if (userExists) {
            return null;
        }
        return userRepository.save(user);
    }

    public List<User> getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> userDb = userRepository.findById(id);
        return userDb.orElse(null);
    }

    public void updateUser(User user, Long id) {
         userRepository
                .findById(id)
                .ifPresent(dbUser -> {
                    dbUser.setName(user.getName());
                    dbUser.setSurname(user.getSurname());
                    dbUser.setEmail(user.getEmail());

                    userRepository.save(dbUser);
                });
    }
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
