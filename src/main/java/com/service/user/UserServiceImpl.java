package com.service.user;

import com.domain.User;
import com.dto.RegistrationDto;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(RegistrationDto registrationDto) {
        try {
            User user = new User();
            user.setUserName(registrationDto.getUsername());
            user.setEmail(registrationDto.getEmail());
            user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
            userRepository.save(user);
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}
