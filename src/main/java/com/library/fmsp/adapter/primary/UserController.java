package com.library.fmsp.adapter.primary;

import com.library.fmsp.application.dto.LoginResultDTO;
import com.library.fmsp.application.dto.UserDTO;
import com.library.fmsp.application.usecase.LoginUseCase;
import com.library.fmsp.application.usecase.SignUpUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final SignUpUseCase signUpUseCase;
    private final LoginUseCase loginUseCase;

    public UserController(SignUpUseCase signUpUseCase, LoginUseCase loginUseCase) {
        this.signUpUseCase = signUpUseCase;
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO){
        var user = signUpUseCase.signUp(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResultDTO> login(@RequestBody UserDTO userDTO){
        var user = loginUseCase.login(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
