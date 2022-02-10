package com.mercadopago.client.oauth;

import lombok.Builder;
import lombok.Getter;

/**
 * Credential information to perform a refresh credential request.
 * Go to <a href="https://www.mercadopago.com.br/developers/en/guides/security/oauth">this page</a> to learn more. */
@Getter
@Builder
public class RefreshOauthCredentialRequest {
  /** Private key to be used in some plugins to generate payments. You can get it in Your credentials. */
  private String clientSecret;

  /** Unique ID that identifies your integration. You can get it in your Mercado Pago credentials */
  private String clientId;

  /** Type of operation to perform to get your credentials. This is a fixed parameter with a refresh_token value.*/
  private final String grantType = "refresh_token";

  /** Value received with your seller's data */
  private String refreshToken;
}