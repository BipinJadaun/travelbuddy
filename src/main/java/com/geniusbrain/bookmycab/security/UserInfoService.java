package com.geniusbrain.bookmycab.security;

import com.geniusbrain.bookmycab.model.User;
import com.geniusbrain.bookmycab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        final User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid User " + userId));

        String user_Id = user.getUserId();
        String password = user.getPassword();
        boolean isActive = user.isActive();
        List<GrantedAuthority> roles = Arrays.stream(user.getRoles().split(","))
                                            .map(SimpleGrantedAuthority::new)
                                            .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user_Id, password, roles);
    }
}
