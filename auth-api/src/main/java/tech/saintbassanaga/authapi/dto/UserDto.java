package tech.saintbassanaga.authapi.dto;

import lombok.*;
import tech.saintbassanaga.authapi.models.UserRole;

import java.io.Serializable;

/**
 * DTO for {@link tech.saintbassanaga.authapi.models.User}
 */
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
public class UserDto{
    String firstname;
    String lastname;
    String email;
    UserRole userRole;
}