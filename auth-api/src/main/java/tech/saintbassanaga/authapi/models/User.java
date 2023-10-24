package tech.saintbassanaga.authapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;

@Entity(name = "User")
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User implements UserDetails {

    // ---------------------------- Entity attributes declarations ----------------------------------->

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "iD")
    private UUID iD;
    @Column(name = "first_name", nullable = false)
    private String firstname;
    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email",unique = true)
    private String email;
    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String pass;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.name()));
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}