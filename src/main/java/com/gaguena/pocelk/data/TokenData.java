package com.gaguena.pocelk.data;

import com.gaguena.pocelk.model.Token;

import lombok.Getter;

@Getter
public class TokenData {

    private String value;

    public TokenData to(Token token) {
      final TokenData data = new TokenData();
      data.value = token.getValue();
      return data;
    }
}
