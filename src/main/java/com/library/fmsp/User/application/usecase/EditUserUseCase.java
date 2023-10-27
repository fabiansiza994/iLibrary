package com.library.fmsp.User.application.usecase;

import com.library.fmsp.User.application.dto.UserDTO;
import com.library.fmsp.User.application.port.UserService;
import org.springframework.stereotype.Service;

@Service
public class EditUserUseCase {
    private final UserService userService;

    public EditUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public UserDTO editUser(UserDTO userDTO){
        return userService.editUser(userDTO);
    }
}
