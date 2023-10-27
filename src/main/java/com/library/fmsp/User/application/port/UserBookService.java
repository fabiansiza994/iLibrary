package com.library.fmsp.User.application.port;

import com.library.fmsp.User.application.dto.UserBooksDTO;

import java.util.List;

public interface UserBookService {
    List<UserBooksDTO> findUserBooksByUserId(Integer userId);
}
