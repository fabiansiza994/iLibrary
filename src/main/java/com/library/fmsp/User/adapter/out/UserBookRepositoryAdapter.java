package com.library.fmsp.User.adapter.out;

import com.library.fmsp.User.adapter.infrastructure.UserRepository;
import com.library.fmsp.User.application.dto.UserBooksDTO;
import com.library.fmsp.User.application.port.UserBookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserBookRepositoryAdapter implements UserBookService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserBookRepositoryAdapter(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserBooksDTO> findUserBooksByUserId(Integer userId) {
        var list = userRepository.findUserBooksByUserId(userId);
        return list.stream().map(item -> modelMapper.map(item, UserBooksDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Double findAveragePriceByUserId(Integer userId) {
        return userRepository.findAveragePriceByUserId(userId).orElseThrow();
    }
}
