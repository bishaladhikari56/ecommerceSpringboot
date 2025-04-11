package com.example.SpringbootEcommerce2025.services.auth;

import com.example.SpringbootEcommerce2025.dto.SignupRequest;
import com.example.SpringbootEcommerce2025.dto.UserDto;
import com.example.SpringbootEcommerce2025.entity.User;
import com.example.SpringbootEcommerce2025.enums.UserRole;
import com.example.SpringbootEcommerce2025.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser(SignupRequest signupRequest){
        User user= new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.ROLE_CUSTOMER);
        User createdUser=userRepository.save(user);

        UserDto userDto=new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;
    }


    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @PostConstruct//after the constructor is callled of this class,
    // this method will be called with this annotation
    public void createAdminAccount(){
        User adminAccount=userRepository.findByRole(UserRole.ROLE_ADMIN);
        if(null ==adminAccount){
            User user=new User();
            user.setEmail("admin@test.com");
            user.setName("admin");
            user.setRole(UserRole.ROLE_ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }

}
