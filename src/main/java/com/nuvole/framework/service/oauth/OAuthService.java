package com.nuvole.framework.service.oauth;

/**
 * Created by chenlong
 * Date：2018/3/27
 * time：17:31
 */
public interface OAuthService {

    void addAuthCode(String authCode, String username);

    void addAccessToken(String accessToken, String username);

    boolean checkAuthCode(String authCode);

    boolean checkAccessToken(String accessToken);

    String getUsernameByAuthCode(String authCode);

    String getUsernameByAccessToken(String accessToken);

    long getExpireIn();

    boolean checkClientId(String clientId);

    boolean checkClientSecret(String clientSecret);

}
