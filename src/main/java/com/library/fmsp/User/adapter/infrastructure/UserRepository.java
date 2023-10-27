package com.library.fmsp.User.adapter.infrastructure;

import com.library.fmsp.User.application.dto.UserBooksDTO;
import com.library.fmsp.User.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(@Param("email") String email);

    @Query(value = "select " +
            "u.id idUser, " +
            "u.nombre userName, " +
            "b.id idBook, " +
            "b.nombre book " +
            " from user_book ub inner join users u on ub.user_id = u.id " +
            " inner join books b on ub.book_id = b.id " +
            " where u.id=:userId ", nativeQuery = true)
    List<projectionDto> findUserBooksByUserId(@Param("userId") Integer userId);

    public interface projectionDto{
        Integer getIdUser();
        String getUserName();
        Integer getIdBook();
        String getBook();
    }
}
