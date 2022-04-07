package com.gaguena.pocelk.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name = "TB_USER_TOKEN")
@SequenceGenerator(name = "ENTITY_SEQ", sequenceName = "USER_TOKEN_SEQ", initialValue = 1, allocationSize = 1)
public class Token extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String value;

    private LocalDateTime expired;

    @ManyToOne
    @JoinColumn(name = "USER")
    private User user;

    public boolean isExpired() {
       return Boolean.FALSE; 
    }

    public static Token create(final User user) {
        final Token token = new Token();
        token.user = user;
        return token;
    }
}
