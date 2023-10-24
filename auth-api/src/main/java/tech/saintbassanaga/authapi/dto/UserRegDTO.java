package tech.saintbassanaga.authapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
