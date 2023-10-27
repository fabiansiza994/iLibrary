package com.library.fmsp.User.application.usecase;

import com.library.fmsp.User.application.dto.UserBooksDTO;
import com.library.fmsp.User.application.port.UserBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindUserBookByUserIdUseCase {

    private final UserBookService userBookService;

    public FindUserBookByUserIdUseCase(UserBookService userBookService) {
        this.userBookService = userBookService;
    }

    public List<UserBooksDTO> findUserBooksByUserId(Integer userId){
        return userBookService.findUserBooksByUserId(userId);
    }
}
