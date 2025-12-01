package com.doosanenc.dsc.common.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doosanenc.dsc.common.mapper.UserMapper;
import com.doosanenc.dsc.common.mapper.UserRepository;
import com.doosanenc.dsc.common.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user = userMapper.findByUserId(username);
        User user = userRepository.findByUserId(username);
        
        
        if (user == null) throw new UsernameNotFoundException("User not found");

        List<GrantedAuthority> authorities = user.getRoles()
            .stream()
            .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
            .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
            user.getUserId(),
            user.getPassword(),
            authorities
        );
    }
}
