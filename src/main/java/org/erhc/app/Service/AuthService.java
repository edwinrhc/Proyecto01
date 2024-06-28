package org.erhc.app.Service;

import lombok.RequiredArgsConstructor;
import org.erhc.app.Auth.AuthResponse;
import org.erhc.app.Auth.LoginRequest;
import org.erhc.app.Auth.RegisterRequest;
import org.erhc.app.Repository.UserRepository;
import org.erhc.app.models.Role;
import org.erhc.app.models.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request){
        return null;
    }

    public AuthResponse register(RegisterRequest request){
       User user = User.builder()
               .username(request.getUsername())
               .password(request.getPassword())
               .firstname(request.getFirstname())
               .lastname(request.getLastname())
               .country(request.getCountry())
               .role(Role.USER)
               .build();

       userRepository.save(user);
       return  AuthResponse.builder()
               .token(jwtService.getToken(user))
               .build();

    }
}
