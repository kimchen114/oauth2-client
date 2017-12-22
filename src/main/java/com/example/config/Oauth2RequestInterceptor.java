// package com.example.config;
//
// import java.util.Arrays;
//
// import org.springframework.security.oauth2.client.OAuth2ClientContext;
// import
// org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
// import
// org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
// import org.springframework.security.oauth2.client.token.AccessTokenProvider;
// import
// org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
// import org.springframework.security.oauth2.client.token.AccessTokenRequest;
// import
// org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
// import
// org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
// import
// org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
// import
// org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
// import
// org.springframework.security.oauth2.client.token.grant.implicit.ImplicitAccessTokenProvider;
// import
// org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
// import org.springframework.security.oauth2.common.OAuth2AccessToken;
//
// import feign.RequestInterceptor;
// import feign.RequestTemplate;
//
// public class Oauth2RequestInterceptor implements RequestInterceptor {
//
// private static String bearer = "Bearer";
// private static String authorization = "Authorization";
// private OAuth2ProtectedResourceDetails resource;
// private CustomOauth2ClientContext customOauth2ClientContext;
// private OAuth2ClientContext oauth2ClientContext;
// private AccessTokenProvider clientCredentialsAccessTokenProvider = new
// ClientCredentialsAccessTokenProvider();
// private AccessTokenProvider accessTokenProvider = new
// AccessTokenProviderChain(Arrays.<AccessTokenProvider>asList(
// new AuthorizationCodeAccessTokenProvider(), new
// ImplicitAccessTokenProvider(),
// new ResourceOwnerPasswordAccessTokenProvider(), new
// ClientCredentialsAccessTokenProvider()));
//
// public Oauth2RequestInterceptor(OAuth2ClientContext oauth2ClientContext,
// CustomOauth2ClientContext customOauth2ClientContext,
// OAuth2ProtectedResourceDetails resource) {
// this.oauth2ClientContext = oauth2ClientContext;
// this.customOauth2ClientContext = customOauth2ClientContext;
// this.resource = resource;
// }
//
// @Override
// public void apply(RequestTemplate template) {
// template.header(authorization, bearer + " " + getToken().getValue());
//
// }
//
// public OAuth2AccessToken getToken() {
// OAuth2AccessToken accessToken = oauth2ClientContext.getAccessToken();
// if (accessToken == null || accessToken.isExpired()) {
// try {
// accessToken = acquireAccessToken();
// } catch (Exception e) {
// accessToken = customOauth2ClientContext.getAccessToken();
// if (accessToken == null || accessToken.isExpired()) {
// accessToken = acquireClientCredentialsAccessToken();
// return accessToken;
// }
// }
// }
// return accessToken;
// }
//
// private OAuth2AccessToken acquireAccessToken() {
// AccessTokenRequest tokenRequest =
// oauth2ClientContext.getAccessTokenRequest();
// if (tokenRequest == null) {
// throw new AccessTokenRequiredException("******", resource);
// }
// String stateKey = tokenRequest.getStateKey();
// if (stateKey == null) {
// tokenRequest.setPreservedState(oauth2ClientContext.removePreservedState(stateKey));
// }
//
// OAuth2AccessToken existToken = oauth2ClientContext.getAccessToken();
// if (existToken != null) {
// oauth2ClientContext.setAccessToken(existToken);
// ;
// }
//
// OAuth2AccessToken oauth2AccessToken =
// accessTokenProvider.obtainAccessToken(resource, tokenRequest);
// if (oauth2AccessToken == null || oauth2AccessToken.getValue() == null) {
// throw new IllegalStateException("------------------");
// }
// oauth2ClientContext.setAccessToken(oauth2AccessToken);
// return oauth2AccessToken;
// }
//
// private OAuth2AccessToken acquireClientCredentialsAccessToken() {
// OAuth2AccessToken oauth2AccessToken;
// ClientCredentialsResourceDetails detail = new
// ClientCredentialsResourceDetails();
// detail.setAccessTokenUri(resource.getAccessTokenUri());
// detail.setClientId(resource.getClientId());
// detail.setClientSecret(resource.getClientSecret());
// oauth2AccessToken =
// clientCredentialsAccessTokenProvider.obtainAccessToken(detail,
// new DefaultAccessTokenRequest());
// if (oauth2AccessToken == null || oauth2AccessToken.getValue() == null) {
// throw new IllegalStateException("------------------");
// }
// customOauth2ClientContext.setAccessToken(oauth2AccessToken);
// return oauth2AccessToken;
// }
//
// }
