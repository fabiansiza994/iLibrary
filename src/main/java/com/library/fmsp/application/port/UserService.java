package com.library.fmsp.application.port;

import com.library.fmsp.application.dto.UserDTO;
import com.library.fmsp.application.dto.UserResultDTO;

import java.util.List;

public interface UserService {
    UserDTO signUp(UserDTO userDTO);
    void verifyEmail(String email);
    List<UserResultDTO> getAllUsers();
    void deleteUser(Integer id);
    UserDTO editUser(UserDTO userDTO);
    UserDTO findById(Integer id);
}
