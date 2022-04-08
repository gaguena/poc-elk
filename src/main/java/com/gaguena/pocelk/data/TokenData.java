package com.gaguena.pocelk.data;

import java.io.Serializable;

import com.gaguena.pocelk.model.Token;

import lombok.Getter;

@Getter
public class TokenData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String value;

    public static TokenData create(final Token token) {
        final TokenData data = new TokenData();
        data.value = token.getValue();
        return data;
    }
}
