package com.gaguena.pocelk.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gaguena.pocelk.model.Token;

@Repository
public interface TokenRepositoy extends JpaRepository<Token, Long> {

    @Query("SELECT t FROM Token t WHERE t.user.email = :email AND t.isExpired()")
    List<Token> findActiveBy(@Param("email") final  String email);
}
