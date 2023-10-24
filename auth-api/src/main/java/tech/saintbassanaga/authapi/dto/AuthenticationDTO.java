package tech.saintbassanaga.authapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class AuthenticationDTO {
    private  String token;
}
