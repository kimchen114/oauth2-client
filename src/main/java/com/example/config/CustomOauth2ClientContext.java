package com.example.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;

// @Component
public class CustomOauth2ClientContext implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3330674189031853511L;
    
    private OAuth2AccessToken accessToken;
    
    private AccessTokenRequest accessTokenRequest;
    
    private Map<String, Object> state = new HashMap<String, Object>();
    
    public CustomOauth2ClientContext() {
        
        this(new DefaultAccessTokenRequest());
    }
    
    public CustomOauth2ClientContext(AccessTokenRequest accessTokenRequest) {
        this.accessTokenRequest = accessTokenRequest;
    }
    
    public CustomOauth2ClientContext(OAuth2AccessToken accessToken) {
        this.accessToken = accessToken;
        this.accessTokenRequest = new DefaultAccessTokenRequest();
    }
    
    public OAuth2AccessToken getAccessToken() {
        return accessToken;
    }
    
    public void setAccessToken(OAuth2AccessToken accessToken) {
        this.accessToken = accessToken;
        this.accessTokenRequest.setExistingToken(accessToken);
    }
    
    public AccessTokenRequest getAccessTokenRequest() {
        return accessTokenRequest;
    }
    
    public void setAccessTokenRequest(AccessTokenRequest accessTokenRequest) {
        this.accessTokenRequest = accessTokenRequest;
    }
    
    public Map<String, Object> getState() {
        return state;
    }
    
    public void setState(String stateKey, Object stateValue) {
        this.state.put(stateKey, stateValue);
    }
    
    public Object removeState(String stateKey) {
        return state.remove(stateKey);
    }
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}
