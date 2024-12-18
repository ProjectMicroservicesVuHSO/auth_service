package hus.vuhso.auth_service.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Entity
@Table(name = "users")
@Builder
@RequiredArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", length = 50, nullable = true)
    private String username;

    @Column(name = "first_name", length = 50, nullable = true)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = true)
    private String lastName;

    @Column(name = "email", length = 100, nullable = true)
    private String email;

    @Column(name = "password", length = 150, unique = true)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "access_token", length = 150, nullable = true)
    private String accessToken;

    @Column(name = "refresh_token", length = 150, nullable = true)
    private String refreshToken;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
