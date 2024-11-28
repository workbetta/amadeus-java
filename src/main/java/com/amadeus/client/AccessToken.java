package com.amadeus.client;

import com.amadeus.HTTPClient;
import com.amadeus.exceptions.ResponseException;

/**
 * A memoized Access Token, with the ability to auto-refresh when needed.
 * @hide as only used internally
 */
public class AccessToken {
  private final HTTPClient client;
  private final TokenManager tokenManager;

  public AccessToken(HTTPClient client) {
    this.client = client;
    this.tokenManager = new TokenManager(client);
  }

  public String getBearerToken() throws ResponseException {
    tokenManager.lazyUpdateAccessToken();
    return String.format("Bearer %s", tokenManager.getTokenValue());
  }
}
