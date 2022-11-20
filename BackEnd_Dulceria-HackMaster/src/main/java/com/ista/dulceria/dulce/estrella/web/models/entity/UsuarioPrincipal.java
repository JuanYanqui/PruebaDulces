package com.ista.dulceria.dulce.estrella.web.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Setter
@Getter
@AllArgsConstructor
public class UsuarioPrincipal implements UserDetails{
    private Long id_usuario;

    private String cedula;
    private String nombres;
    private String username;
    @JsonIgnore
    private String contrasenia;
    private Boolean estado;

    private Collection<? extends GrantedAuthority> authorities;

    public static UsuarioPrincipal build(Usuario user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombre_rol()))
                .collect(Collectors.toList());
        return new UsuarioPrincipal(user.getId_usuario(),
                user.getCedula(),
                user.getNombres(),
                user.getUsername(),
                user.getContrasenia(),
                user.getEstado(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return contrasenia;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UsuarioPrincipal user = (UsuarioPrincipal) o;
        return Objects.equals(id_usuario, user.id_usuario);
    }

}
