package com.library.fmsp.application.usecase;

import com.library.fmsp.application.dto.UserDTO;
import com.library.fmsp.config.Constants;
import com.library.fmsp.config.exception.IncorrectCredentials;
import com.library.fmsp.config.security.CustomerDetailService;
import com.library.fmsp.config.security.jwt.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginUseCase {

    private final AuthenticationManager authenticationManager;

    private final CustomerDetailService customerDetailService;

    private final JwtUtil jwtUtil;

    public LoginUseCase(AuthenticationManager authenticationManager, CustomerDetailService customerDetailService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.customerDetailService = customerDetailService;
        this.jwtUtil = jwtUtil;
    }

    public String login(UserDTO userDTO){
        log.info("haciendo login");
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword())
            );

            if(authentication.isAuthenticated()){
                if(customerDetailService.getUserDetail().getStatus()){
                    return jwtUtil.generateToken(customerDetailService.getUserDetail().getEmail(),
                            customerDetailService.getUserDetail().getRole());

                }
            }
        }catch (Exception e){
            log.error("{}", e);
        }
        throw new IncorrectCredentials(Constants.INCORRECT_CREDENTIALS);
    }
}
