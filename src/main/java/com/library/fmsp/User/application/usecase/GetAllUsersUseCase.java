package com.library.fmsp.User.application.usecase;

import com.library.fmsp.User.application.dto.UserResultDTO;
import com.library.fmsp.User.application.port.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsersUseCase {

    private final UserService userService;

    public GetAllUsersUseCase(UserService userService) {
        this.userService = userService;
    }

    public List<UserResultDTO> getAllUsers(){
        return userService.getAllUsers();
    }
}
