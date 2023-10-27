package com.library.fmsp.User.application.usecase;

import com.library.fmsp.User.application.port.UserBookService;
import org.springframework.stereotype.Service;

@Service
public class FindAveragePriceByUserIdUseCase {

    private final UserBookService userBookService;

    public FindAveragePriceByUserIdUseCase(UserBookService userBookService) {
        this.userBookService = userBookService;
    }

    public Double getAveragePriceForUser(Integer userId) {
        return userBookService.findAveragePriceByUserId(userId);
    }
}
