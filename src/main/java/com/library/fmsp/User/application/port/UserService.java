package com.library.fmsp.User.application.port;

import com.library.fmsp.User.application.dto.UserDTO;
import com.library.fmsp.User.application.dto.UserResultDTO;

import java.util.List;

public interface UserService {
    UserDTO signUp(UserDTO userDTO);
    void verifyEmail(String email);
    List<UserResultDTO> getAllUsers();
    void deleteUser(Integer id);
    UserDTO editUser(UserDTO userDTO);
    UserDTO findById(Integer id);
}
