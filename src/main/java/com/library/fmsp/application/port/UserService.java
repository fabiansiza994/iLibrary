package com.library.fmsp.application.port;

import com.library.fmsp.application.dto.UserDTO;

public interface UserService {
    UserDTO signUp(UserDTO userDTO);
    void verifyEmail(String email);
}
