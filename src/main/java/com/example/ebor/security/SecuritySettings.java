package com.example.ebor.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(prefix = "app.security")
public class SecuritySettings {
    @NotNull
    private String[] permitUrl;

    @NotNull
    private String[] protectUrl;

    @NotNull
    private Integer tokenExpirationTime;

    @NotNull
    private String tokenSigningKey;

    @NotNull
    private String tokenHeaderParam;

    @NotNull
    private Integer refreshTokenExpTime;

    public Integer getRefreshTokenExpTime() {
        return refreshTokenExpTime;
    }

    public void setRefreshTokenExpTime(Integer refreshTokenExpTime) {
        this.refreshTokenExpTime = refreshTokenExpTime;
    }

    public Integer getTokenExpirationTime() {
        return tokenExpirationTime;
    }

    public void setTokenExpirationTime(Integer tokenExpirationTime) {
        this.tokenExpirationTime = tokenExpirationTime;
    }

    public String getTokenSigningKey() {
        return tokenSigningKey;
    }

    public void setTokenSigningKey(String tokenSigningKey) {
        this.tokenSigningKey = tokenSigningKey;
    }

    public String getTokenHeaderParam() {
        return tokenHeaderParam;
    }

    public void setTokenHeaderParam(String tokenHeaderParam) {
        this.tokenHeaderParam = tokenHeaderParam;
    }

    public String[] getPermitUrl() {
        return permitUrl;
    }

    public void setPermitUrl(String[] permitUrl) {
        this.permitUrl = permitUrl;
    }

    public String[] getProtectUrl() {
        return protectUrl;
    }

    public void setProtectUrl(String[] protectUrl) {
        this.protectUrl = protectUrl;
    }
}
