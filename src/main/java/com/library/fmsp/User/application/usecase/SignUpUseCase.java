package com.library.fmsp.User.application.usecase;

import com.library.fmsp.User.application.dto.UserDTO;
import com.library.fmsp.User.application.port.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SignUpUseCase {
    private final UserService userService;

    public SignUpUseCase(UserService userService) {
        this.userService = userService;
    }

    public UserDTO signUp(UserDTO userDTO){
        log.info("registrando usuario...");
        userService.verifyEmail(userDTO.getEmail());
        return userService.signUp(userDTO);
    }
}
