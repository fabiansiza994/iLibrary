package com.library.fmsp.User.adapter.out;

import com.library.fmsp.User.adapter.infrastructure.UserRepository;
import com.library.fmsp.User.application.dto.UserDTO;
import com.library.fmsp.User.application.dto.UserResultDTO;
import com.library.fmsp.User.application.port.UserService;
import com.library.fmsp.User.domain.User;
import com.library.fmsp.config.Constants;
import com.library.fmsp.config.exception.UserAlreadyExist;
import com.library.fmsp.config.exception.UserNotFound;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        log.info("usario registrado");
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void verifyEmail(String email) {
        var user = findByEmail(email);
        if(user.isPresent()){
            log.error(Constants.USER_ALREADY_EXIST);
            throw new UserAlreadyExist(Constants.USER_ALREADY_EXIST);
        }
    }

    @Override
    public List<UserResultDTO> getAllUsers() {
        var users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserResultDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO editUser(UserDTO userDTO) {
        var userDb = findById(userDTO.getId());
        modelMapper.map(userDTO, userDb);
        return modelMapper.map(userRepository.save(modelMapper.map(userDb, User.class)), UserDTO.class);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDTO findById(Integer id){
        var userDb = userRepository.findById(id);
        if(userDb.isEmpty()){
            log.error(Constants.USER_NOT_FOUND);
            throw new UserNotFound(Constants.USER_NOT_FOUND);
        }
        return modelMapper.map(userDb.get(), UserDTO.class);
    }

}
