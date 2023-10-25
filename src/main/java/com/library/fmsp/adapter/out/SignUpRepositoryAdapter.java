package com.library.fmsp.adapter.out;

import com.library.fmsp.adapter.infrastructure.UserRepository;
import com.library.fmsp.application.dto.UserDTO;
import com.library.fmsp.application.port.UserService;
import com.library.fmsp.config.Constants;
import com.library.fmsp.config.exception.UserAlreadyExist;
import com.library.fmsp.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class SignUpRepositoryAdapter implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public SignUpRepositoryAdapter(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO signUp(UserDTO userDTO) {
        var user = userRepository.save(modelMapper.map(userDTO, User.class));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void verifyEmail(String email) {
        var user = findByEmail(email);
        if(user.isPresent()){
            throw new UserAlreadyExist(Constants.USER_ALREADY_EXIST);
        }
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
