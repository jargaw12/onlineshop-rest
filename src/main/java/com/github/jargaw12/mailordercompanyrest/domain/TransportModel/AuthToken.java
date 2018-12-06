package com.github.jargaw12.mailordercompanyrest.domain.TransportModel;

import org.codehaus.jackson.annotate.JsonProperty;

public class AuthToken {
    @JsonProperty
    private
    String accessToken;
    @JsonProperty
    private
    String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    public AuthToken setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getTokenType() {
        return tokenType;
    }

    public AuthToken setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }
}
