package com.library.fmsp.config.security;

import com.library.fmsp.adapter.infrastructure.UserRepository;
import com.library.fmsp.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.library.fmsp.domain.User;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class CustomerDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user = userRepository.findByEmail(username).orElseThrow();
       if(!Objects.isNull(user)){
           return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
       }else{
           throw new UsernameNotFoundException(Constants.USER_NOT_FOUND);
       }
    }

    public User getUserDetail(){
        return user;
    }
}
