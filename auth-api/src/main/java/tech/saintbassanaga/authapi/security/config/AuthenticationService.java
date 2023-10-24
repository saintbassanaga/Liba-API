package tech.saintbassanaga.authapi.security.config;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.saintbassanaga.authapi.dto.AuthenticationDTO;
import tech.saintbassanaga.authapi.dto.UserRegDTO;
import tech.saintbassanaga.authapi.dto.UserAuthenticationDTO;
import tech.saintbassanaga.authapi.models.User;
import tech.saintbassanaga.authapi.models.UserRole;
import tech.saintbassanaga.authapi.repositories.UserRepository;
import tech.saintbassanaga.authapi.services.JWTService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    public void register(UserRegDTO request)
    {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .pass(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .userRole(UserRole.USER)
                .build();

        userRepository.save(user);

    }
    public AuthenticationDTO authenticate(UserAuthenticationDTO request)
    {
        authenticationManager.authenticate((
                new UsernamePasswordAuthenticationToken(request.getEmail(),
                        request.getPassword())
                ));

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDTO.builder().token(jwtToken).build();

    }
}
