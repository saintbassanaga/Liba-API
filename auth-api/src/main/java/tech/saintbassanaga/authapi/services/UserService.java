package tech.saintbassanaga.authapi.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.saintbassanaga.authapi.dto.UserDto;
import tech.saintbassanaga.authapi.models.User;
import tech.saintbassanaga.authapi.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


@Service
public class UserService implements UserDetailsService {
    final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
       this.userRepository = userRepository;
    }

    public Function<UserRepository, List<UserDto>> findAllUsers = repository -> {
        List<UserDto> userList = new ArrayList<>();
        for (User user : new ArrayList<>(userRepository.findAll())
        ) {
            var userDto = UserDto.builder()
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .email(user.getEmail())
                    .userRole(user.getUserRole())
                    .build();
            userList.add(userDto);
        }
        return userList;
    };

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
}
