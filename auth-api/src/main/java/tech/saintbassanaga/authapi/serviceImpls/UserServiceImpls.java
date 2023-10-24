package tech.saintbassanaga.authapi.serviceImpls;

import tech.saintbassanaga.authapi.repositories.UserRepository;
import tech.saintbassanaga.authapi.services.UserService;

public class UserServiceImpls extends UserService {
    public UserServiceImpls(UserRepository userRepository) {
        super(userRepository);
    }
}
