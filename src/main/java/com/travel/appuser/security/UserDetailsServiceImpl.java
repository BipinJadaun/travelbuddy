package com.travel.appuser.security;

import com.travel.appuser.model.AppUser;
import com.travel.appuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        final AppUser appUser = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid AppUser " + userId));

        return new User(appUser);
    }
}
