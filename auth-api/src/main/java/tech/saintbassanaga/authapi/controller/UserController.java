package tech.saintbassanaga.authapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.saintbassanaga.authapi.dto.UserDto;
import tech.saintbassanaga.authapi.models.User;
import tech.saintbassanaga.authapi.repositories.UserRepository;
import tech.saintbassanaga.authapi.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDto> findUser(UserRepository userRepository)
    {
      return userService.findAllUsers.apply(userRepository);
    }
}
