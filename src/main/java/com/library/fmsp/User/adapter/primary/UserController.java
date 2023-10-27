package com.library.fmsp.User.adapter.primary;

import com.library.fmsp.User.application.dto.*;
import com.library.fmsp.User.application.usecase.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Tag(name = "Users")
public class UserController {

    private final SignUpUseCase signUpUseCase;
    private final LoginUseCase loginUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final EditUserUseCase editUserUseCase;
    private final FindUserBookByUserIdUseCase findUserBookByUserIdUseCase;
    private final FindAveragePriceByUserIdUseCase findAveragePriceByUserIdUseCase;

    @Operation(description = "Post endpoint for create users",
    responses = {@ApiResponse(description = "Success", responseCode = "201"),
            @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@Valid @RequestBody UserDTO userDTO){
        var user = signUpUseCase.signUp(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @Operation(description = "Post endpoint for Login users",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @PostMapping("/login")
    public ResponseEntity<LoginResultDTO> login(@Valid @RequestBody LoginDTO loginDTO){
        var user = loginUseCase.login(loginDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(description = "Post endpoint for list all users",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @GetMapping
    public ResponseEntity<List<UserResultDTO>> getUsers(){
        var users = getAllUsersUseCase.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(description = "Post endpoint for delete users by id",
            responses = {@ApiResponse(description = "Success", responseCode = "204"),
                    @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        deleteUserUseCase.deleteUserById(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Operation(description = "Post endpoint for edit users",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @PutMapping("/edit_user")
    public ResponseEntity<UserDTO> editUser(@Valid @RequestBody UserDTO userDTO){
        var user = editUserUseCase.editUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(description = "Post endpoint for list all Books for User ID",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @GetMapping("get_books_by_user_id/{userId}")
    public ResponseEntity<List<UserBooksDTO>> getBookByUserId(@PathVariable Integer userId){
        var userBookList = findUserBookByUserIdUseCase.findUserBooksByUserId(userId);
        return new ResponseEntity<>(userBookList, HttpStatus.OK);
    }

    @Operation(description = "Using JPQL to Calculate the Average Price of a User's Books",
            responses = {@ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @GetMapping("get_average_books_by_user_id/{userId}")
    public ResponseEntity<Double> getAverageBookByUserId(@PathVariable Integer userId){
        var averagePrice = findAveragePriceByUserIdUseCase.getAveragePriceForUser(userId);
        return new ResponseEntity<>(averagePrice, HttpStatus.OK);
    }
}
