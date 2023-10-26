package com.library.fmsp.adapter.primary;

import com.library.fmsp.application.dto.LoginDTO;
import com.library.fmsp.application.dto.LoginResultDTO;
import com.library.fmsp.application.dto.UserDTO;
import com.library.fmsp.application.dto.UserResultDTO;
import com.library.fmsp.application.usecase.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final SignUpUseCase signUpUseCase;
    private final LoginUseCase loginUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final EditUserUseCase editUserUseCase;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@Valid @RequestBody UserDTO userDTO){
        var user = signUpUseCase.signUp(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResultDTO> login(@Valid @RequestBody LoginDTO loginDTO){
        var user = loginUseCase.login(loginDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResultDTO>> getUsers(){
        var users = getAllUsersUseCase.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        deleteUserUseCase.deleteUserById(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/edit_user")
    public ResponseEntity<UserDTO> editUser(@Valid @RequestBody UserDTO userDTO){
        var user = editUserUseCase.editUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
