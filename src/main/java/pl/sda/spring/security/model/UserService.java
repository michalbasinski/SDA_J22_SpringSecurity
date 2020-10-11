package pl.sda.spring.security.model;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.spring.security.dto.UserDto;

import java.util.Arrays;
import java.util.HashSet;

@Component
@RequiredArgsConstructor
class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    boolean isUsernameTaken(String username) {
        User user = userRepository.findUserByUsername(username);
        return user != null;
    }

    UserDto saveUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setEncodedPassword(encodedPassword);
        user.setIsActive(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
        return new UserDto(user.getId(), user.getUsername());
    }

    UserDto findUserByEmail(String name) {
        User user = userRepository.findUserByUsername(name);
        return new UserDto(user.getId(), user.getUsername());
    }
}
