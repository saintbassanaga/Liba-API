package tech.saintbassanaga.authapi.controller;





import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.saintbassanaga.authapi.dto.UserAuthenticationDTO;
import tech.saintbassanaga.authapi.dto.AuthenticationDTO;
import tech.saintbassanaga.authapi.security.config.AuthenticationService;
import tech.saintbassanaga.authapi.dto.UserRegDTO;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public void register(
            @RequestBody UserRegDTO request
    )
    {
       service.register(request);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationDTO> authenticate(
            @RequestBody UserAuthenticationDTO request
    )
    {
        return  ResponseEntity.ok(service.authenticate(request));
    }
}
