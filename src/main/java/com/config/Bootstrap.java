package com.config;

import com.domain.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements InitializingBean {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            if (userRepository.count() == 0) {
                User user = new User();
                user.setUserName("Jeevesh");
                user.setEmail("jeevesh.pandey@tothenew.com");
                user.setPassword(passwordEncoder.encode("igdefault"));
                userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
