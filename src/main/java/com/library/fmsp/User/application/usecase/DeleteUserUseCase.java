package com.library.fmsp.User.application.usecase;

import com.library.fmsp.User.application.port.UserService;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCase {

    private final UserService userService;

    public DeleteUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public void deleteUserById(Integer id){
        userService.deleteUser(id);
    }
}
